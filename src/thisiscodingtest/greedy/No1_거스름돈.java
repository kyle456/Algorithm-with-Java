package thisiscodingtest.greedy;

import java.util.Scanner;

public class No1_거스름돈 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] unitCoin = { 500, 100, 50, 10 }; // 거스름돈 단위
		int charge = scanner.nextInt(); // 거슬러 줘야할 돈
		int i = 0;
		int count = 0;
		
		do {
			count += charge / unitCoin[i];
			charge %= unitCoin[i];
			i++;
		} while (charge != 0);
		
		System.out.println(count);
	}

}
