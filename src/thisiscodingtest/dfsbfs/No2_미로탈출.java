package thisiscodingtest.dfsbfs;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

// 큐에 삽입할 (x, y) 형태의 자료형을 임의로 제작
class Node {
	private int x, y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	// x 좌표 얻기
	public int getX() {
		return this.x;
	}
	
	// y 좌표 얻기
	public int getY() {
		return this.y;
	}
}

public class No2_미로탈출 {
	public static int n, m;
	public static int[][] maze;
	public static int[] dx = { -1, 1, 0, 0 }; // 상하좌우에 사용되는 x 좌표의 변량
	public static int[] dy = { 0, 0, -1, 1 }; // 상하좌우에 사용되는 y 좌표의 변량

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 미로의 세로 크기
		m = sc.nextInt(); // 미로의 가로 크기
		sc.nextLine();

		maze = new int[n][m];

		for (int i = 0; i < n; i++) {
			String oneLine = sc.nextLine();
			for (int j = 0; j < m; j++) {
				maze[i][j] = oneLine.charAt(j) - '0'; // 미로 구조
			}
		}

		System.out.println(bfs(0, 0));

	}

	// 최단 거리 탐색을 위한 너비 우선 탐색
	public static int bfs(int x, int y) {
		Queue<Node> mazeQ = new LinkedList<>();
		mazeQ.offer(new Node(x, y)); // 시작점 삽입

		while (!mazeQ.isEmpty()) {
			// 상하좌우로 이동
			for (int i = 0; i < 4; i++) {
				int nextX = mazeQ.peek().getX() + dx[i]; // 다음 x 좌표
				int nextY = mazeQ.peek().getY() + dy[i]; // 다음 y 좌표
				
				// 다음 이동할 node가 미로의 범위 내에 있고, 방문하지 않은 경우(값이 1일 때 방문하지 않은 것임)
				if ((nextX >= 0 && nextX < n) && (nextY >= 0 && nextY < m) && (maze[nextX][nextY] == 1)) {
					maze[nextX][nextY] = maze[nextX - dx[i]][nextY - dy[i]] + 1; // 이전 방문 node 수 누적
					mazeQ.offer(new Node(nextX , nextY)); // 인접 node 삽입
				}
			}
			mazeQ.poll(); // 큐에서 삭제
		}
		
		return maze[n - 1][m - 1]; // 목적지
	}

}
