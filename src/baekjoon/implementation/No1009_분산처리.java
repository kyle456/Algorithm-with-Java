package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class No1009_분산처리 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		int[] result = new int[t]; // 결과값

		for (int i = 0; i < t; i++) {
			String[] integerAB = br.readLine().split(" ");
			int a = Integer.parseInt(integerAB[0]); // 정수 a
			int b = Integer.parseInt(integerAB[1]); // 정수 b
			int computer = newPow(a, b);

			if (computer == 0) {
				result[i] = 10;
			} else {
				result[i] = computer;
			}
		}

		for (int i : result) {
			System.out.println(i);
		}

		br.close();
	}
	
	// a의 b제곱 값의 1의 자리 반환
	public static int newPow(int a, int b) {
		int temp = a;
		
		for (int i = 1; i < b; i++) {
			a *= temp;
			
			// 10이상일 경우 1자리 수로 만듦
			if (a >= 10) {
				a %= 10;
			}
		}
		
		if (a >= 10) {
			a %= 10;
		}

		return a;
	}

}
