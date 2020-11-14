package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Wall {
	private int x, y;

	Wall(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int getX() {
		return this.x;
	}

	int getY() {
		return this.y;
	}
}

public class No2206_벽부수고이동하기 {
	static int n, m;
	static int[][] map;
	static int[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로
		map = new int[n][m];
		visited = new int[n][m];
		ArrayList<Integer> results = new ArrayList<Integer>();

		// 지도 기록
		for (int i = 0; i < n; i++) {
			String oneLine = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = oneLine.charAt(j) - '0';
			}
		}
		
		br.close();
		results.add(bfs(0, 0)); // 벽을 부수지 않았을 때 bfs
		
		// 벽을 1개 부쉈을 때 bfs
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					visited = new int[n][m]; // visited 초기화
					map[i][j] = 0; // 벽 1개 부수기
					results.add(bfs(0, 0));
					map[i][j] = 1; // 벽 원래대로 복구
				}
			}
		}
		
		Collections.sort(results);
		
		if (results.get(results.size() - 1) == 0) {
			// 불가능 할 때 예외처리(최장 경로가 0인 경우)
			System.out.println(-1);
		} else {
			// 가능할 때는 0을 제외한 최단 경로 출력
			for (int i : results) {
				if (i != 0) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	public static int bfs(int x, int y) {
		Queue<Wall> queue = new LinkedList<Wall>();
		queue.offer(new Wall(x, y));
		visited[x][y] = 1; // 방문 처리

		while (!queue.isEmpty()) {
			Wall wall = queue.poll(); // 큐에서 제거
			x = wall.getX();
			y = wall.getY();
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (newX >= 0 && newX < n && newY >= 0 && newY < m && map[newX][newY] == 0 && visited[newX][newY] == 0) {
					queue.offer(new Wall(newX, newY)); // 큐에 삽입
					visited[newX][newY] = visited[x][y] + 1; // 방문 처리
				}
			}
		}

		return visited[n - 1][m - 1];
	}

}
