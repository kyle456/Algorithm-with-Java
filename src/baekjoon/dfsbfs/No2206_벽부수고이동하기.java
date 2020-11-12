package baekjoon.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 세로
		m = sc.nextInt(); // 가로
		map = new int[n][m];
		visited = new int[n][m];
		ArrayList<Integer> results = new ArrayList<Integer>();
		sc.nextLine(); // 버퍼 제거

		// 지도 기록
		for (int i = 0; i < n; i++) {
			String oneLine = sc.nextLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = oneLine.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					map[i][j] = 0;
					results.add(bfs(0, 0));
					map[i][j] = 1;
				}
			}
		}
		
		Collections.sort(results);
		
		if (results.get(results.size() - 1) == 0) {
			// 불가능 할 때 예외처리
			System.out.println(-1);
		} else {
			System.out.println(results.get(0));
		}
		
		/*
		 * 1. visited가 한번 사용하고 초기화가 안됨
		 * 2. 벽을 안부수고도 bfs를 해야하고, 벽을 부쉈을 때와 비교도 해야함
		 * 3. 불가능하지 않은데도 results.get(0)이 0인경우가 있음 이것을 해결
		 * */
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
