package thisiscodingtest.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class No9_볼링공고르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 볼링공의 개수
		int m = sc.nextInt(); // 볼링공의 최대 무게
		
		int[] ballWeight = new int[m + 1];
		
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			ballWeight[x] += 1;
		}
		
		int result = 0; // 경우의 수
		
		for (int i = 1; i <= m; i++) {
			n -= ballWeight[i];
			result += ballWeight[i] * n;
		}
		
		System.out.println(result);

	}

}
