package baekjoon.implementation;

import java.util.Scanner;

public class No10773_제로 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int k = scanner.nextInt(); // 입력할 정수의 갯수
		int[] numbers = new int[k]; // 재민이가 부르는 수
		int sum = 0;

		for (int i = 0; i < k; i++) {
			numbers[i] = scanner.nextInt();

			if (numbers[i] == 0) {
				for (int j = i - 1; j >= 0; j--) {
					if (numbers[j] != 0) {
						numbers[j] = 0;
						break;
					}
				}
			}
		}

		for (int i = 0; i < k; i++) {
			sum += numbers[i];
		}

		System.out.println(sum);

	}

}
