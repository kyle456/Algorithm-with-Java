package thisiscodingtest.dfsbfs;

import java.util.Scanner;

public class No1_음료수얼려먹기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 얼음판의 세로
		int m = sc.nextInt(); // 얼음판의 가로
		sc.nextLine();		
		int[][] ice = new int[n][m];
		int count = 0;
		
		for (int i = 0; i < n; i++) {
			String oneLine = sc.nextLine();
			String[] oneLineSplit = oneLine.split("");
			for (int j = 0; j < m; j++) {
				ice[i][j] = Integer.parseInt(oneLineSplit[j]);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (dfs(ice, i, j, n, m)) {
					count++;
				}
			}
		}
		
		System.out.println(count);

	}
	
	// 상하좌우 dfs 탐색
	public static boolean dfs (int[][] ice, int i, int j, int n, int m) {
		if ((i < 0 || i >= n) || (j < 0 || j >= m) || ice[i][j] == 1) {
			return false;
		} else if (ice[i][j] == 0) {
			ice[i][j] = 1; // 방문하면 표시
			
			dfs(ice, i - 1, j, n, m); // 상
			dfs(ice, i + 1, j, n, m); // 하
			dfs(ice, i, j - 1, n, m); // 좌
			dfs(ice, i, j + 1, n, m); // 우
		}
		
		return true;
	}

}
