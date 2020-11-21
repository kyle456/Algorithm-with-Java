package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class No9012_괄호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> bracket; // 괄호를 담는 스택
		
		int n = Integer.parseInt(br.readLine()); // 테스트케이스 수
		String[] result = new String[n]; // 결과 값 담는 배열
		
		loop:
		for (int i = 0; i < n; i++) {
			String oneLine = br.readLine();
			bracket = new Stack<Character>(); // 스택 초기화
			for (int j = 0; j < oneLine.length(); j++) {
				char temp = oneLine.charAt(j);
				if (temp == '(') {
					bracket.push(temp); // '(' 이면 push
				} else {
					if (bracket.isEmpty()) {
						result[i] = "NO"; // ')'인데 스택이 빈 상태면 VPS가 아님
						continue loop;
					} else {
						bracket.pop();
					}
				}
			}
			if (bracket.isEmpty()) {
				result[i] = "YES";
			} else {
				result[i] = "NO";
			}
			
		}
		
		for (String i : result) {
			System.out.println(i);
		}

	}

}
