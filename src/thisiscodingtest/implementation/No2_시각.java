package thisiscodingtest.implementation;

import java.util.Scanner;

public class No2_시각 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // 정수 n
		int count = 0; // 3이 등장한 시각의 총 횟수
		
		for (int i = 0; i <= n; i++) {
			if (i == 3 || i == 13 || i == 23)
				count += 3600; // 3이 등장하는 hour 때는 전체 초를 다 더함
			else
				count += 1575; // 3이 등장하지 않는 hour 때는 3이 등장하는 minute과 second의 횟수를 더함
		}
		
		System.out.println(count);
	}

}
