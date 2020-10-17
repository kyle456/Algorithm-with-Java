package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class No11399_ATM {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // 줄 선 사람 수
		int[] p = new int[n]; // 각 사람이 걸리는 시간
		
		for (int i = 0; i < n; ++i) {
			p[i] = scanner.nextInt();
		}
		
		Arrays.sort(p);
		int minSum = 0; // 총 걸리는 시간의 최소값
		int k = n; // 각 사람마다 더해지는 횟수
		
		for (int i = 0; i < n; ++i) {
			minSum += (p[i] * k--);
		}
		
		System.out.println(minSum);
	}

}
