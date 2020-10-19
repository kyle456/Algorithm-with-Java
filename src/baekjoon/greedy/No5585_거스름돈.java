package baekjoon.greedy;

import java.util.Scanner;

public class No5585_거스름돈 {
	private static final int[] COIN = { 500, 100, 50, 10, 5, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int cost = scanner.nextInt(); // 물건의 비용
		int charge = 1000 - cost; // 거스름돈
		int count = 0; // 거스름돈 동전의 개수
		int index = 0;
		
		while (charge != 0) {
			count += charge / COIN[index];
			charge %= COIN[index++];
		}
		
		System.out.println(count);

	}

}
