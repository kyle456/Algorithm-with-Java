package baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class No1475_방번호 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String n = scanner.next(); // 다솜이의 방 번호
		
		// 숫자 한 세트(0~8) : 원래는 0~9이지만 6,9는 뒤집어서 사용할 수 있기 때문에 8까지만 배열 생성
		int[] number = new int[9];
		
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) - '0' == 9) // 9일때는 6에 1을 더함. 뒤집어서 사용할 수 있기 때문
				number[6]++;
			else
				number[n.charAt(i) - '0']++; // 그 이외에는 해당 숫자에 1을 더함
		}
		
		number[6] = (int) Math.ceil(number[6] / 2.0); // 9의 경우도 반영되어 있으므로
		Arrays.sort(number); // 가장 높은 숫자 = 필요한 세트의 갯수
		
		System.out.println(number[8]);
	}
}
