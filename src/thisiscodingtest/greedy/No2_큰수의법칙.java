package thisiscodingtest.greedy;

import java.util.Scanner;

public class No2_큰수의법칙 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // 배열의 크기
		int m = scanner.nextInt(); // 숫자가 더해지는 횟수
		int k = scanner.nextInt(); // 연속으로 더해질 수 있는 횟수
		int[] numberArray = new int[n]; // 더할 수들
		
		int firstNum = 0; // 가장 큰 수
		int secondNum = 0; // 두 번째로 큰 수
		
		for (int i = 0; i < n; i++) {
			numberArray[i] = scanner.nextInt();
			
			if (numberArray[i] >= firstNum) {
				// 가장 큰 수와 두 번째로 큰 수 구하기
				secondNum = firstNum;
				firstNum = numberArray[i];
			}
		}
		
		// 내 풀이
		int sum = 0; // 총 합
		int serialCount = 0; // firstNum이 연속으로 더해지는 횟수
		
		for (int i = 0; i < m; i++) {
			serialCount++;
			
			if (serialCount > k) {
				// 연속으로 더해질 횟수를 초과하면
				sum += secondNum;
				serialCount = 0;
			} else {
				// 연속으로 더해질 횟수를 아직 초과하지 않으면
				sum += firstNum;
			}
		}
		
		/*나동빈님 풀이
		int countFirst = ((m / (k + 1)) * k) + (m % (k + 1)); // 가장 큰 수가 더해진 총 횟수
		int countSecond = m - countFirst; // 두 번째 수가 더해진 총 횟수
		
		int sum = (firstNum * countFirst) + (secondNum * countSecond);*/
		
		System.out.println(sum);
		
	}

}
