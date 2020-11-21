package hufs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Board {
	int x, y;

	Board(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class No6_보드이동 {
	static int r, c;
	static char[][] map;
	static int[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Character> arr = new ArrayList<Character>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new int[r][c];

		for (int i = 0; i < r; i++) {
			String oneLine = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = oneLine.charAt(j);
			}
		}

		br.close();
		bfs(0, 0);

		int max = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				max = Math.max(visited[i][j], max);
			}
		}
		System.out.print(max);
	}

	public static void bfs(int x, int y) {
		Queue<Board> queue = new LinkedList<Board>();
		queue.offer(new Board(x, y));
		visited[x][y] = 1;
		arr.add(map[x][y]);

		while (!queue.isEmpty()) {
			Board board = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = board.x + dx[i];
				int newY = board.y + dy[i];

				if (newX >= 0 && newY >= 0 && newX < r && newY < c && visited[newX][newY] == 0
						&& arr.indexOf(map[newX][newY]) == -1) {
					queue.offer(new Board(newX, newY));
					arr.add(map[newX][newY]);
					visited[newX][newY] = visited[board.x][board.y] + 1;
				}
			}
		}
	}

}

