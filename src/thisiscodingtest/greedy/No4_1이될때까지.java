package thisiscodingtest.greedy;

import java.util.Scanner;

public class No4_1이될때까지 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt(); // 임의의 수
		int K = scanner.nextInt(); // 나눌 수
		int count = 0;	
		
		if (K == 1) {
			System.out.println(N - 1);
		} else {
			while (N != 1) {
				if (N % K == 0) {
					// N이 K로 나누어 떨어지는 경우
					N /= K;
					count++;
				} else {
					// N이 K로 나누어 떨어지지 않는 경우
					N--;
					count++;
				}
			}
			
			System.out.println(count);
		}	

	}

}
