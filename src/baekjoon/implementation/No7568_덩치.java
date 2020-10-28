package baekjoon.implementation;

import java.util.Scanner;

public class No7568_덩치 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt(); // 사람의 수
		int[][] eachPerson = new int[n][2]; // 각 사람의 몸무게, 키
		int[] order = new int[n]; // 각 사람의 덩치 순위

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				eachPerson[i][j] = scanner.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 몸무게와 키가 모두 자신보다 크다면
				if (eachPerson[i][0] < eachPerson[j][0] && eachPerson[i][1] < eachPerson[j][1]) {
					order[i]++;
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			System.out.print(order[i] + 1 + " ");
		}

	}

}
