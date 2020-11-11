package baekjoon.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Tomato2 {
	private int x, y, z;

	Tomato2(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	int getX() {
		return this.x;
	}

	int getY() {
		return this.y;
	}
	
	int getZ() {
		return this.z;
	}
}

public class No7569_토마토3차원 {
	// 상, 하, 좌, 우, 위, 아래
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0};
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt(); // 가로
		int n = sc.nextInt(); // 세로
		int h = sc.nextInt(); // 높이
		int[][][] box = new int[h][n][m];
		boolean allOne = true; // 모든 토마토가 익은 상태인지 판별

		// 상자에 토마토 위치 기록
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					box[k][i][j] = sc.nextInt();
					if (box[k][i][j] != 1 && allOne) {
						allOne = false; // 하나라도 안 익어있다면 false
					}
				}
			}
		}
		
		// 모든 토마토가 이미 익어있다면 0 출력 후 종료
		if (allOne) {
			System.out.println(0);
			return;
		}

		bfs(n, m, h, box);
		int max = 0;
		
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {				
					if (box[k][i][j] == 0) {
						System.out.println(-1); // 토마토가 다 익지 못했다면 -1 출력
						return;
					}
					
					max = Math.max(max, box[k][i][j]); // 기록된 값 중 최대값이 토마토가 익는 최소 일 수
				}
			}
		}
		

		System.out.println(max - 1);
	}

	public static void bfs(int n, int m, int h, int[][][] box) {
		Queue<Tomato2> queue = new LinkedList<Tomato2>();
		
		// 이미 익어있는 토마토의 위치 전부 큐에 삽입
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (box[k][i][j] == 1) {
						queue.offer(new Tomato2(i, j, k));
					}
				}
			}
		}
		
		while (!queue.isEmpty()) {
			int x = queue.peek().getX();
			int y = queue.peek().getY();
			int z = queue.peek().getZ();
			
			// 상,하,좌,우,위,아래 이동
			for (int i = 0; i < 6; i++) {
				int newX = x + dx[i];
				int newY = y + dy[i];
				int newZ = z + dz[i];

				if (newX >= 0 && newX < n && newY >= 0 && newY < m && newZ >= 0 && newZ < h && box[newZ][newX][newY] == 0) {
					queue.offer(new Tomato2(newX, newY, newZ));
					box[newZ][newX][newY] = box[z][x][y] + 1;
				}
			}
			
			queue.poll();
		}
	}
}
