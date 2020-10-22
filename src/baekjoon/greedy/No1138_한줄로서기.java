package baekjoon.greedy;

import java.util.Scanner;

public class No1138_한줄로서기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // 사람의 수
		int[] leftPeople = new int[n + 1]; // 자기보다 키가 큰 왼쪽 사람의 수
		int[] line = new int[n]; // 줄을 선 순서 (결과 값)
		
		for (int i = 1; i <= n; ++i) {
			leftPeople[i] = scanner.nextInt();
		}
		
		for (int i = n; i >= 1; --i) {
			line[leftPeople[i]] = i; // 일단 가장 키 큰 사람을 왼쪽에 세움
		}
		
		// 키 큰 사람부터 왼쪽에 계속 차례대로 세우다가
		// 조건에 맞지 않는 사람이 나타나면 조건에 맞을 때 까지
		// 왼쪽 사람이랑 switching 하기
		// 일단 세운 다음에 n 인덱스부터 조건을 만족하는지 계속 검사하는 방식으로 하면 될듯

	}

}
