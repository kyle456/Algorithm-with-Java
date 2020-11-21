import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
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
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x, y));
		visited[x][y] = 1;
		arr.add(map[x][y]);

		while (!queue.isEmpty()) {
			Point point = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = point.x + dx[i];
				int newY = point.y + dy[i];

				if (newX >= 0 && newY >= 0 && newX < r && newY < c && visited[newX][newY] == 0
						&& arr.indexOf(map[newX][newY]) == -1) {
					queue.offer(new Point(newX, newY));
					arr.add(map[newX][newY]);
					visited[newX][newY] = visited[point.x][point.y] + 1;
				}
			}
		}
	}

}
