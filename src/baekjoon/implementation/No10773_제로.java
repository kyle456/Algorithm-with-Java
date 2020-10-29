package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No10773_제로 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine()); // 입력받을 정수의 갯수
		ArrayList<Integer> numbers = new ArrayList<Integer>(); // 재민이가 부르는 수
		int temp = 0; // 임시 저장
		int sum = 0; // 합계
		
		for (int i = 0; i < k; i++) {
			temp = Integer.parseInt(br.readLine()); 
			
			// 0이 아니면 numbers에 저장
			if (temp != 0) {
				numbers.add(temp);
			} 
			// 0이면 numbers의 맨 끝에 있는 정수 삭제
			else {
				numbers.remove(numbers.size() - 1);
			}
		}
		
		br.close();
		
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
		}
		
		System.out.println(sum);
	}

}
