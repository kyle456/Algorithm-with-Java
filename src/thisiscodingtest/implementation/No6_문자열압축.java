// 2020 카카오 신입 공채 기출 문제

package thisiscodingtest.implementation;

import java.util.Scanner;

public class No6_문자열압축 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String s = scanner.next(); // 입력 문자열
		int answer = s.length(); // 최종 답 (가장 적은 용량의 표현)
		String temp = "";
		int count, sum, start, end;
		
		for (int i = 1; i <= s.length() / 2; i++) {
			count = 0;
			sum = 0;
			start = 0;
			end = start + i;
			temp = s.substring(start, end); // 기준 문자열
			
			while (true) {
				// 기준 문자열 == 자른 문자열
				if (temp.equals(s.substring(start, end))) {
					count++;					
				} 
				// 기준 문자열 != 자른 문자열
				else {
					// 압축 후의 길이(후보 답들) : 1개 이상 연속되면 숫자도 압축 문자열에 포함
					if (count > 1) {
						sum += temp.length() + Integer.toString(count).length(); 
					} else {
						sum += temp.length();
					}
					
					count = 1;					
					temp = s.substring(start, end); // 기준 문자열 교체
					
				}
				
				start += i;
				end = start + i;
				
				// 묶음에 포함되지 않는 끝의 잔여 알파벳 처리
				if (end > s.length()) {						
					if (count > 1) {
						sum += temp.length() + Integer.toString(count).length(); 
					} else {
						sum += temp.length();
					}
					
					if (start < s.length())
						sum += s.length() - start;
					
					break;
				}
			}
			
			answer = Math.min(answer, sum);
		}
		
		System.out.println(answer);

	}

}
