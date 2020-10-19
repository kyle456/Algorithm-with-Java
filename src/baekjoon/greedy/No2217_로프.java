package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class No2217_로프 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // 로프의 개수
		int[] rope = new int[n]; // 각 로프가 버틸 수 있는 최대 중량
		
		for (int i = 0; i < n; ++i) {
			rope[i] = scanner.nextInt();
		}
		
		Arrays.sort(rope);
		int maxWeight = 0; // 가능한 물체의 최대 중량
		
		for (int i = 0; i < n; ++i) {
			int weight = rope[i] * (n - i);
			
			maxWeight = Math.max(maxWeight, weight);
		}
		
		System.out.println(maxWeight);
	}

}
