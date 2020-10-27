package baekjoon.implementation;

import java.util.Scanner;

public class No18406_럭키스트레이트 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String scoreN = scanner.nextLine();
		String[] scoreNSplit = scoreN.split("");
		
		int left = 0;
		int right = 0;
		
		for (int i = 0; i < scoreNSplit.length; i++) {
			if (i < scoreNSplit.length / 2) {
				left += Integer.parseInt(scoreNSplit[i]);
			} else {
				right += Integer.parseInt(scoreNSplit[i]);
			}
		}
		
		if (left == right) {
			System.out.println("LUCKY");
		} else {
			System.out.println("READY");
		}
	}

}
