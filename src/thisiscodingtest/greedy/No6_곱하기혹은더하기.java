package thisiscodingtest.greedy;

import java.util.Scanner;

public class No6_곱하기혹은더하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		String[] sSplit = s.split("");
		int[] sSplitNumber = new int[sSplit.length]; // 입력한 문자열을 각각의 숫자로 변환
		
		for(int i = 0; i < sSplitNumber.length; ++i) {
			sSplitNumber[i] = Integer.parseInt(sSplit[i]);
		}
		
		int result = sSplitNumber[0];
		
		for(int i = 1; i < sSplitNumber.length; ++i) {
			if (sSplitNumber[i] <= 1 || result <= 1) {
				result += sSplitNumber[i];
			} else {
				result *= sSplitNumber[i];
			}
		}
		
		System.out.println(result);
	}

}
