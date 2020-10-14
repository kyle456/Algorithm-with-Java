package thisiscodingtest.greedy;

import java.util.Scanner;

public class No7_문자열뒤집기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		if (s.charAt(s.length() - 1) == '0') {
			s += "1";
		} else {
			s += "0";
		}
		
		int zero = 0;
		int one = 0;
		
		for(int i = 0; i < s.length() - 1; ++i) {
			if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') {
				zero++;
			} else if (s.charAt(i) == '1' && s.charAt(i + 1) == '0') {
				one++;
			}
		}
		
		System.out.println(zero < one ? zero : one);
	}

}
