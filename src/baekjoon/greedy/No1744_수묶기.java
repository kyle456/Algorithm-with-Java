package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1744_수묶기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 수열의 크기
		int[] numArr = new int[n];
		
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		Arrays.sort(numArr);
		
		int medium = -1;
		int index = n - 1;
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			if (numArr[i] <= 0) {
				medium = i;
			}
		}
		
		// 양수 부분 묶기
		while (index > medium) {
			if (index - 1 > medium)
				sum += numArr[index] * numArr[index - 1];
			else
				sum += numArr[index];
			
			index -= 2;
		}
		
		index = 0;
		
		// 음수 부분 묶기
		while (index <= medium) {
			if (index < medium)
				sum += numArr[index] * numArr[index + 1];
			else
				sum += numArr[index];
			
			index += 2;
		}
		
		System.out.println(sum);
	}

}
