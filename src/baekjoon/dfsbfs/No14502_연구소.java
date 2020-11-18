package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Block {
	int x, y;

	Block(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class No14502_연구소 {
	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 세로
		m = Integer.parseInt(st.nextToken()); // 가로
		map = new int[n][m]; // 지도

		// 지도 기록하기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		int count = 0;
		
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < m; b++) {
				if (map[a][b] == 0) {
					for (int c = a; c < n; c++) {
						for (int d = b + 1; d < m; d++) {
							if (map[c][d] == 0) {
								for (int e = c; e < n; e++) {
									for (int f = d + 1; f < m; f++) {
										if (map[e][f] == 0) {
											map[a][b] = 1;
											map[c][d] = 1;
											map[e][f] = 1;
											visited = new boolean[n][m];
											bfs();
											
											for (int i = 0; i < n; i++) {
												for (int j = 0; j < m; j++) {
													if (!visited[i][j]) {
														count++;
													}
												}
											}
											
											map[a][b] = 0;
											map[c][d] = 0;
											map[e][f] = 0;
											
											max = Math.max(count, max);
											count = 0;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(max);

	}

	public static void bfs() {
		Queue<Block> queue = new LinkedList<Block>();
		
		// 바이러스가 있는 곳 모두 큐에 삽입 (BFS 병렬 진행을 위함)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					queue.offer(new Block(i, j));
				}
				if (map[i][j] != 0) {
					visited[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			Block block = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = block.x + dx[i];
				int newY = block.y + dy[i];

				if (newX >= 0 && newX < n && newY >= 0 && newY < m && map[newX][newY] == 0
						&& !visited[newX][newY]) {
					queue.offer(new Block(newX, newY));
					visited[newX][newY] = true;
				}
			}
		}
	}

}