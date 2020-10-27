package thisiscodingtest.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class No5_문자열재정렬 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.next();
		String[] sSplit = s.split("");
		int sum = 0;
		
		Arrays.sort(sSplit);
		
		for (String i : sSplit) {
			char eachOne = i.charAt(0);
			
			if (eachOne >= 48 && eachOne <= 57) {
				sum += eachOne - '0';
			} else {
				System.out.print(eachOne);
			}
		}
		
		if (sum != 0)
			System.out.println(sum);
	}

}
