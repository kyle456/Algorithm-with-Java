package baekjoon.dfsbfs;

import java.io.*;
import java.util.*;

class Virus {
	int x, y, second;

	Virus(int x, int y, int second) {
		this.x = x;
		this.y = y;
		this.second = second;
	}
}

public class No18405_경쟁적전염 {
	static int n, k, s, x, y;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 시험관의 크기(n x n)
		k = Integer.parseInt(st.nextToken()); // 바이러스의 종류(1번 ~ k번)
		int[][] testTube = new int[n][n]; // 시험관

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				testTube[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken()); // s초 뒤에
		x = Integer.parseInt(st.nextToken()) - 1; // x와
		y = Integer.parseInt(st.nextToken()) - 1; // y 좌표에 존재하는 바이러스 찾기
		
		System.out.println(bfs(testTube));

	}

	public static int bfs(int[][] testTube) {
		Queue<Virus> queue = new LinkedList<Virus>();
		
		// 1번 바이러스부터 차례대로 queue에 삽입
		for (int virusNum = 1; virusNum <= k; virusNum++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (testTube[i][j] == virusNum) {
						queue.offer(new Virus(i, j, 0)); // 최초 바이러스 위치 & 0초로 초기화
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Virus virus = queue.poll();
			int second = virus.second;
			
			if (second == s) {
				return testTube[x][y]; // s초에 도달하면 return
			}
			
			for (int i = 0; i < 4; i++) {
				int newX = virus.x + dx[i];
				int newY = virus.y + dy[i];
				
				if (newX >= 0 && newX < n && newY >= 0 && newY < n && testTube[newX][newY] == 0) {
					queue.offer(new Virus(newX, newY, second + 1));
					testTube[newX][newY] = testTube[virus.x][virus.y]; // 감염 처리
				}
			}
		}
		
		return testTube[x][y];

	}

}
