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

		// 수열이 1개만 있을 때 예외 처리
		if (n == 1) {
			System.out.println(numArr[0]);
			return;
		}

		Arrays.sort(numArr);

		int medium = -1; // 가장 오른쪽에 있는 0 혹은 음수의 위치
		int index = n - 1;
		int sum = 0;

		// medium 위치 찾기
		for (int i = 0; i < n; i++) {
			if (numArr[i] <= 0) {
				medium = i;
			}
		}

		// 양수 부분 묶기
		while (index > medium) {
			if (index - 1 > medium) {
				if (numArr[index - 1] == 1) {
					// 곱할 숫자가 1일 때는 곱셈보다 덧셈이 유리
					sum += numArr[index] + numArr[index - 1];
				} else {
					sum += numArr[index] * numArr[index - 1];
				}
			} else {
				sum += numArr[index];
			}				
			index -= 2;
		}

		index = 0; // 음수는 값이 작을 수록 서로 곱했을 때 커지므로, index를 0으로 초기화

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
