package baekjoon.greedy;

import java.util.Scanner;

public class No1783_병든나이트 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt(); // 체스판의 세로 길이
		int m = scanner.nextInt(); // 체스판의 가로 길이

		int count = 1;

		if ((n == 1) || (m == 1) || (n <= 2 && m <= 2)) {
			count = 1;
		} else if (n == 2 && m >= 3) {
			if (m <= 7) {
				count += (m - 1) / 2;
			} else {
				count = 4;
			}
		} else if (n >= 3) {
			if (m <= 3) {
				count = m;
			} else if (m <= 6) {
				count = 4;
			} else {
				count = m - 2;
			}
		}

		System.out.println(count);

	}

}
