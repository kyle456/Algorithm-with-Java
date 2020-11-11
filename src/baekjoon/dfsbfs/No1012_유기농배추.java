package baekjoon.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Cabbage {
	private int x, y;
	
	Cabbage(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	int getX() { return this.x; }
	int getY() { return this.y; }
}

public class No1012_유기농배추 {
	static int m, n;
	static int[][] field; // 배추밭
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 테스트케이스 개수
		int[] results = new int[t]; // 각 테스트케이스에서 필요한 배추흰지렁이의 수

		for (int i = 0; i < t; i++) {
			m = sc.nextInt(); // 가로
			n = sc.nextInt(); // 세로
			field = new int[m][n];
			int k = sc.nextInt(); // 배추의 개수

			// 배추밭 기록
			for (int j = 0; j < k; j++) {
				field[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			// dfs
			for (int x = 0; x < m; x++) {
				for (int y = 0; y < n; y++) {
					if (dfs(x, y)) {
						results[i]++;
					}
				}
			}
			
			// bfs
			for (int x = 0; x < m; x++) {
				for (int y = 0; y < n; y++) {
					if (bfs(x, y)) {
						results[i]++;
					}
				}
			}
		}

		for (int i : results) {
			System.out.println(i);
		}
	}

	public static boolean dfs(int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n || field[x][y] == 0) {
			return false;
		} else {
			field[x][y] = 0; // 방문 처리
			dfs(x - 1, y); // 좌
			dfs(x + 1, y); // 우
			dfs(x, y - 1); // 상
			dfs(x, y + 1); // 하

			return true;
		}
	}
	
	public static boolean bfs(int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n || field[x][y] == 0) {
			return false;
		} else {
			Queue<Cabbage> queue = new LinkedList<>();
			queue.offer(new Cabbage(x, y)); // 큐에 삽입
			field[x][y] = 0; // 방문 처리
			
			while (!queue.isEmpty()) {
				// 상하좌우 이동
				for (int i = 0; i < 4; i++) {
					int newX = queue.peek().getX() + dx[i];
					int newY = queue.peek().getY() + dy[i];
					
					if (newX >= 0 && newX < m && newY >= 0 && newY < n && field[newX][newY] == 1) {
						queue.offer(new Cabbage(newX, newY)); // 큐에 삽입
						field[newX][newY] = 0; // 방문 처리
					}
				}
				queue.poll();
			}			
			return true;
		}
	}

}
