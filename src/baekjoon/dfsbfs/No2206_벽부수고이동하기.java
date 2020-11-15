package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Wall {
	private int x, y, breaking;

	Wall(int x, int y, int breaking) {
		this.x = x;
		this.y = y;
		this.breaking = breaking;
	}

	int getX() {
		return this.x;
	}

	int getY() {
		return this.y;
	}

	int getBreaking() {
		return this.breaking;
	}
}

public class No2206_벽부수고이동하기 {
	static int n, m;
	static int[][] map;
	static int[][][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로
		map = new int[n][m];
		visited = new int[n][m][2];

		// 지도 기록
		for (int i = 0; i < n; i++) {
			String oneLine = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = oneLine.charAt(j) - '0';
			}
		}
		
		br.close();
		bfs(0, 0);
		int noBreakResult = visited[n - 1][m - 1][0]; // 벽을 부수지 않았을 때 결과
		int yesBreakResult = visited[n - 1][m - 1][1]; // 벽을 부쉈을 때 결과
		
		if (noBreakResult == 0 && yesBreakResult == 0) {
			System.out.println(-1);
		} else if (noBreakResult != 0 && yesBreakResult != 0) {
			System.out.println(Math.min(noBreakResult, yesBreakResult));
		} else {
			System.out.println(Math.max(noBreakResult, yesBreakResult));
		}
	}

	public static void bfs(int x, int y) {
		Queue<Wall> queue = new LinkedList<Wall>();
		queue.offer(new Wall(x, y, 0));
		visited[x][y][0] = 1;
		visited[x][y][1] = 1;

		while (!queue.isEmpty()) {
			Wall wall = queue.poll();
			x = wall.getX();
			y = wall.getY();
			int breaking = wall.getBreaking(); // 벽을 부수고 왔는지 안 부수고 왔는지

			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
					if (map[newX][newY] == 1) {
						// 다음이 벽이면
						if (breaking == 0 && visited[newX][newY][1] == 0) {
							// 전에 벽을 부순적이 없고, 갈 수 있는 곳이라면
							queue.offer(new Wall(newX, newY, 1));
							visited[newX][newY][1] = visited[x][y][0] + 1;
						}
					} else {
						// 다음이 벽이 아니면
						if (visited[newX][newY][breaking] == 0) {
							// 갈 수 있는 곳이라면
							queue.offer(new Wall(newX, newY, breaking));
							visited[newX][newY][breaking] = visited[x][y][breaking] + 1;
						}
					}
				}
			}
		}
	}

}
