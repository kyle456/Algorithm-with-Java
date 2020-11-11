package baekjoon.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato {
	private int x, y;

	Tomato(int x, int y) {
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

public class No7576_토마토 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); // 가로
		int n = sc.nextInt(); // 세로
		int[][] box = new int[n][m];
		boolean allOne = true; // 모든 토마토가 익은 상태인지 판별

		// 상자에 토마토 위치 기록
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				box[i][j] = sc.nextInt();
				if (box[i][j] != 1 && allOne) {
					allOne = false; // 하나라도 안 익어있다면 false
				}
			}
		}

		// 모든 토마토가 이미 익어있다면 0 출력 후 종료
		if (allOne) {
			System.out.println(0);
			return;
		}

		bfs(n, m, box);
		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {				
				if (box[i][j] == 0) {
					System.out.println(-1); // 토마토가 다 익지 못했다면 -1 출력
					return;
				}
				
				max = Math.max(max, box[i][j]); // 기록된 값 중 최대값이 토마토가 익는 최소 일 수
			}
		}

		System.out.println(max - 1);
	}

	public static void bfs(int n, int m, int[][] box) {
		Queue<Tomato> queue = new LinkedList<>();
		
		// 이미 익어있는 토마토의 위치 전부 큐에 삽입
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 1) {
					queue.offer(new Tomato(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			int x = queue.peek().getX();
			int y = queue.peek().getY();
			
			// 상하좌우 이동
			for (int i = 0; i < 4; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];

				if (newX >= 0 && newX < n && newY >= 0 && newY < m && box[newX][newY] == 0) {
					queue.offer(new Tomato(newX, newY));
					box[newX][newY] = box[x][y] + 1;
				}
			}
			
			queue.poll();
		}
	}
}
