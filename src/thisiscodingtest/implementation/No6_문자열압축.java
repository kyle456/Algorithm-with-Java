package thisiscodingtest.implementation;

import java.util.Scanner;

public class No6_문자열압축 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		int answer = Integer.MAX_VALUE;
		
		StringBuffer standardString = new StringBuffer(1000);
		StringBuffer compareString = new StringBuffer(1000);
		StringBuffer resultString = new StringBuffer(1000);

		for (int unit = 1; unit <= s.length() / 2; unit++) {
			int startIndex = 0;
			int count = 1;
			standardString.append(s.substring(startIndex, unit));

			while (true) {
				startIndex += unit;
				
				if (startIndex + unit > s.length()) break;
				
				compareString.append(s.substring(startIndex, startIndex + unit));

				if (standardString.toString().equals(compareString.toString())) {
					count++;
				} else {
					if (count > 1) 
						resultString.append(Integer.toString(count));
					
					resultString.append(standardString.toString());
					
					standardString.delete(0, standardString.length());
					standardString.append(s.substring(startIndex, startIndex + unit));
					count = 1;
				}
				System.out.println(count);
				compareString.delete(0, compareString.length());
			}
			
			if (resultString.length() < answer) {
				answer = resultString.length();
			}
			
		
			System.out.println(resultString.toString());
			
			resultString.delete(0, resultString.length());
		}
		
		System.out.println(answer);

	}

}
