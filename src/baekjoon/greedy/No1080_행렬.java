package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class No1080_행렬 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt(); // 행의 개수
		int m = scanner.nextInt(); // 열의 개수
		scanner.nextLine();

		int[][] matrixA = new int[n][m]; // 행렬A
		int[][] matrixB = new int[n][m]; // 행렬B

		// 행렬A
		for (int i = 0; i < n; ++i) {
			String oneLine = scanner.nextLine();
			String[] oneLineSplit = oneLine.split("");

			for (int j = 0; j < m; ++j) {
				matrixA[i][j] = Integer.parseInt(oneLineSplit[j]);
			}
		}

		// 행렬B
		for (int i = 0; i < n; ++i) {
			String twoLine = scanner.nextLine();
			String[] twoLineSplit = twoLine.split("");

			for (int j = 0; j < m; ++j) {
				matrixB[i][j] = Integer.parseInt(twoLineSplit[j]);
			}
		}

		int count = 0;

		// 3 x 3 연산의 가용 범위까지 연산 (그리디 하게, 행렬A와 행렬B가 다른 원소가 존재하기만 하면 바로 연산)
		for (int i = 0; i <= n - 3; ++i) {
			for (int j = 0; j <= m - 3; ++j) {
				if (matrixA[i][j] != matrixB[i][j]) {
					trans(matrixA, i, j);
					count++;
				}
			}
		}

		if (Arrays.deepEquals(matrixA, matrixB)) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}

	}

	// 3 x 3 범위 만큼 0 -> 1 , 1 -> 0 으로 바꿔주는 함수
	public static void trans(int[][] matrixA, int row, int column) {
		for (int i = row; i < row + 3; ++i) {
			for (int j = column; j < column + 3; ++j) {
				// matrixA[i][j]가 0이면 1로, 1이면 0으로 (^ 연산자 사용)
				matrixA[i][j] ^= 1;
			}
		}

	}

}
