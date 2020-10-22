package baekjoon.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class No1138_한줄로서기 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt(); // 사람의 수
		int[] leftPeople = new int[n]; // 자기보다 키가 큰 왼쪽 사람의 수
		ArrayList<Integer> line = new ArrayList<Integer>(n); // 줄을 선 순서 (결과 값)
		
		// 초기 값 생성
		for (int i = 0; i < n; ++i) {
			leftPeople[i] = scanner.nextInt();
			line.add(null);
		}

		// leftPeople의 값이 곧 line의 인덱스, line의 값은 leftPeople의 인덱스 + 1
		for (int i = n - 1; i >= 0; --i) {
			line.add(leftPeople[i], i + 1);
		}
		
		// 결과 출력
		for (int i = 0; i < n; ++i) {
			System.out.print(line.get(i) + " ");
		}
	}
}
