package thisiscodingtest.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class No3_숫자카드게임 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // 행
		int m = scanner.nextInt(); // 열
		int[][] cardBoard = new int[n][m]; // 덮여진 카드 들
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				cardBoard[i][j] = scanner.nextInt();
			}
		}
		
		Arrays.sort(cardBoard[0]); // 첫 줄 정렬
		int result = cardBoard[0][0]; // 첫 줄에서 가장 작은 값을 일단 result에 삽입
		
		for (int i = 1; i < n; i++) {
			Arrays.sort(cardBoard[i]); // 두 번째 줄부터 정렬
			
			if (result < cardBoard[i][0])
				result = cardBoard[i][0]; // 두 번째 줄부터 가장 작은 값이 기존 result값 보다 크면 result에 삽입
		}
		
		System.out.println(result);
	}

}
