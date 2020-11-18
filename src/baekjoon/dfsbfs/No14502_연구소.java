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
		
		int max = 0; // 안전 영역의 최대값 (count 중 최대)
		int count = 0; // 벽 3개를 세울 때 마다 생기는 안전 영역
		
		// 가장 바깥 쪽 for (첫 번째 벽)
		for (int a = 0; a < n; a++) {
			for (int b = 0; b < m; b++) {
				if (map[a][b] == 0) {
					int tempA = a;
					int tempB = b + 1;
					if (b == m - 1) {
						tempA = a + 1;
						tempB = 0;
					}
					// 중간 for (두 번째 벽)
					for (int c = tempA; c < n; c++) {
						for (int d = tempB; d < m; d++) {
							if (map[c][d] == 0) {
								int tempC = c;
								int tempD = d + 1;
								if (d == m - 1) {
									tempC = c + 1;
									tempD = 0;
								}
								// 가장 안 쪽 for (세 번째 벽)
								for (int e = tempC; e < n; e++) {
									for (int f = tempD; f < m; f++) {
										if (map[e][f] == 0) {
											map[a][b] = 1; // 첫 번째 벽
											map[c][d] = 1; // 두 번째 벽
											map[e][f] = 1; // 세 번째 벽
											visited = new boolean[n][m]; // 감염 배열 초기화
											bfs();
											
											// 벽을 세우고 바이러스가 퍼졌을 때, 남아있는 안전 영역 세기
											for (int i = 0; i < n; i++) {
												for (int j = 0; j < m; j++) {
													if (!visited[i][j]) {
														count++;
													}
												}
											}
											
											// 벽을 다시 빈 공간으로 돌려 놓기
											map[a][b] = 0;
											map[c][d] = 0;
											map[e][f] = 0;
											
											max = Math.max(count, max);
											count = 0;
										}
									}
									tempD = 0;
								}
							}
						}
						tempB = 0;
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
					queue.offer(new Block(i, j)); // 바이러스가 있는 곳은 모두 큐에 삽입
				}
				if (map[i][j] != 0) {
					visited[i][j] = true; // 바이러스 & 벽이 있는 곳 표시
				}
			}
		}

		while (!queue.isEmpty()) {
			Block block = queue.poll();
			
			// 상하좌우 이동
			for (int i = 0; i < 4; i++) {
				int newX = block.x + dx[i];
				int newY = block.y + dy[i];

				if (newX >= 0 && newX < n && newY >= 0 && newY < m && map[newX][newY] == 0
						&& !visited[newX][newY]) {
					queue.offer(new Block(newX, newY));
					visited[newX][newY] = true; // 감염 처리
				}
			}
		}
	}

}