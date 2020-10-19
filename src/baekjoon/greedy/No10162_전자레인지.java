package baekjoon.greedy;

import java.util.Scanner;

public class No10162_전자레인지 {
	private static final int[] BUTTON = { 300, 60, 10 }; // 전자레인지 각 버튼의 초
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int t = scanner.nextInt(); // 요리시간 T초
		int[] buttonCount = new int[BUTTON.length]; // 버튼이 눌린 횟수
		
		for (int i = 0; i < BUTTON.length; ++i) {
			if (t >= BUTTON[i]) {
				buttonCount[i] += t / BUTTON[i];
				t %= BUTTON[i];
			}
		}
		
		if (t != 0)
			System.out.println(-1);
		else {
			for (int i = 0; i < buttonCount.length; ++i) {
				System.out.print(buttonCount[i] + " ");
			}
		}
		
		System.out.println();
	}

}
