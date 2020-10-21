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

		int[][] matrixA = new int[n][m];
		int[][] matrixB = new int[n][m];

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

		if (n < 3 || m < 3) {
			if (!Arrays.deepEquals(matrixA, matrixB)) {
				System.out.println(-1);
			} else {
				System.out.println(0);
			}

			return;
		}

		int count = 0;
		int rowIndex = 0;
		int colIndex = 0;

		while (!Arrays.deepEquals(matrixA, matrixB)) {
			if (matrixA[rowIndex][colIndex] != matrixB[rowIndex][colIndex]) {
				for (int i = rowIndex; i < rowIndex + 3; ++i) {
					for (int j = colIndex; j < colIndex + 3; ++j) {
						if (matrixA[i][j] == 0)
							matrixA[i][j] = 1;
						else
							matrixA[i][j] = 0;
					}
				}

				count++;
			}
			
			if (colIndex + 3 < m) {
				colIndex++;
			} else {
				if (matrixA[rowIndex][colIndex + 1] != matrixB[rowIndex][colIndex + 1]
						|| matrixA[rowIndex][colIndex + 2] != matrixB[rowIndex][colIndex + 2]) {
					System.out.println(-1);
					return;
				}
				colIndex = 0;
				rowIndex++;
				
				if (rowIndex + 2 >= n) {
					if (!Arrays.deepEquals(matrixA, matrixB)) {
						count = -1;
					}
					break;
				}
				
			}
		}

		System.out.println(count);

	}

}
