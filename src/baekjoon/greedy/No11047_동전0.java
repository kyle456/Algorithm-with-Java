package baekjoon.greedy;

import java.util.Scanner;

public class No11047_동전0 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // 동전 갯수
		int k = scanner.nextInt(); // 가치의 합
		int[] coins = new int[n]; // 각 동전의 단위
		
		for (int i = 0; i < n; ++i) {
			coins[i] = scanner.nextInt();
		}
		
		int index = n - 1; // 배열의 끝에서 부터 대입
		int count = 0; // k를 만들 수 있는 최소의 동전의 수
		
		while (true) {
			count += k / coins[index]; // 나누어 떨어진 만큼 count
			k %= coins[index--]; // k를 동전으로 나눈 나머지를 다시 k에 대입
			
			if (k == 0) {
				break; // k를 만들면 break
			}
		}
		
		System.out.println(count);
	}

}
