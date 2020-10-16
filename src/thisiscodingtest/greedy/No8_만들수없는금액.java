package thisiscodingtest.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class No8_만들수없는금액 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] coin = new int[n];
		
		for (int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
		}
		
		
		Arrays.sort(coin);
		int result = 1; // 가장 작은 양의 정수인 1부터 시작
		
		for (int i = 0; i < n; i++) {
			if (result < coin[i]) {
				// 해당 숫자보다 화폐 단위가 클 경우, 못 만듦
				break;
			} else {
				// 해당 숫자보다 화폐 단위가 작을 경우, 숫자 + 화폐 단위
				result += coin[i];
			}
		}
		
		System.out.println(result);

	}

}
