package baekjoon.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	private int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}
}

public class No2667_단지번호붙이기 {
	static int n, group, house; // 지도의 크기, 단지수, 집의 수
	static int[][] map; // 지도

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> eachHouses = new ArrayList<Integer>(); // 각 단지에 속한 집의 수
		n = sc.nextInt();
		sc.nextLine(); // 버퍼 처리
		map = new int[n][n];
		group = 0;
		house = 0;

		// 지도 입력
		for (int i = 0; i < n; i++) {
			String oneLine = sc.nextLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = oneLine.charAt(j) - '0';
			}
		}

//		// dfs로 탐색
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (dfs(i, j)) {
//					group++;
//					eachHouses.add(house);
//					house = 0;
//				}
//			}
//		}

		// bfs로 탐색
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (bfs(i, j)) {
					group++;
					eachHouses.add(house);
					house = 0;
				}
			}
		}

		Collections.sort(eachHouses); // 오름차순 정렬

		System.out.println(group);
		for (int i : eachHouses) {
			System.out.println(i);
		}
	}

	public static boolean dfs(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n || map[x][y] == 0) {
			// 지도의 범위를 벗어나거나, 이미 방문 했다면
			return false;
		} else {
			map[x][y] = 0; // 방문처리
			house++;

			dfs(x - 1, y); // 상
			dfs(x + 1, y); // 하
			dfs(x, y - 1); // 좌
			dfs(x, y + 1); // 우

			return true;
		}
	}

	public static boolean bfs(int x, int y) {
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		if (x < 0 || x >= n || y < 0 || y >= n || map[x][y] == 0) {
			// 지도의 범위를 벗어나거나, 이미 방문 했다면
			return false;
		}

		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(x, y));

		while (!queue.isEmpty()) {
			for (int i = 0; i < 4; i++) {
				int newX = queue.peek().getX() + dx[i];
				int newY = queue.peek().getY() + dy[i];

				if (newX >= 0 && newX < n && newY >= 0 && newY < n && map[newX][newY] == 1) {
					queue.offer(new Point(newX, newY));
				}

				queue.poll();
			}
		}

		return true;
	}

}
