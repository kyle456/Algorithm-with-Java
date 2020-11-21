package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1987_알파벳 {
	static int r, c;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[] alphabet = new int[26];
	static int[][] board;
	static int max = 0; // 결과 값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); // 세로
		c = Integer.parseInt(st.nextToken()); // 가로
		board = new int[r][c]; // 보드

		for (int i = 0; i < r; i++) {
			String oneLine = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = oneLine.charAt(j) - 65; // A:65 ~ Z:90 (character to integer)
			}
		}

		br.close();
		alphabet[board[0][0]] = 1; // 출발점 알파벳 기록
		dfs(0, 0, 0);

		System.out.println(max);

	}

	public static void dfs(int x, int y, int pastCount) {
		max = Math.max(++pastCount, max); // 이동할 때마다 최대값 갱신
		
		// 상하좌우 이동
		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			
			if (newX >= 0 && newX < r && newY >= 0 && newY < c && alphabet[board[newX][newY]] == 0) {
				alphabet[board[newX][newY]] = 1; // 방문한 알파벳 표시
				dfs(newX, newY, pastCount);
				alphabet[board[newX][newY]] = 0; // 다른 경로로 가기 위해 기존 알파벳 지움
			}
		}

	}

}
