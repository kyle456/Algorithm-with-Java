package baekjoon.greedy;

import java.util.Scanner;

public class No2839_설탕배달 {
	private static final int PACK1 = 3;
	private static final int PACK2 = 5;
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); // 배달 무게
		
		int min = (n / PACK1) + (n / PACK2); // 최대치로 min 설정
		boolean notExist = true; // 딱 떨어지는지 아닌지 확인
		
		for (int i = 0; i <= (n / PACK1); ++i) {
			for (int j = 0; j <= (n / PACK2); ++j) {
				if ((PACK1 * i) + (PACK2 * j) == n & i + j <= min) {
					// 일차방정식의 해 중 x + y의 최솟값을 찾는 과정
					min = i + j;
					notExist = false;
				}
			}
		}
		
		if (notExist) {
			// 딱 떨어지지 않으면 -1 반환
			min = -1;
		}
		
		System.out.println(min);
	}

}
