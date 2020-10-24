package thisiscodingtest.implementation;

import java.util.Scanner;

public class No3_왕실의나이트 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String location = scanner.next(); // 현재 나이트가 위치한 좌표

		char column = location.charAt(0); // 좌표의 열 (a~h)
		int row = location.charAt(1) - '0'; // 좌표의 행 (1~8)
		
		int[] columnMove = { -2, -2, 2, 2, -1, -1, 1, 1 }; // 수평으로 움직일 수 있는 범위
		int[] rowMove = { -1, 1, -1, 1, -2, 2, -2, 2 }; // 수직으로 움직일 수 있는 범위
		
		int count = 0; // 결과 값
		
		for (int i = 0; i < columnMove.length; i++) {
			char newColumn = (char) (column + columnMove[i]);
			int newRow = row + rowMove[i];
			
			if (newColumn >= 'a' && newColumn <= 'h' && newRow >= 1 && newRow <= 8) {
				// 체스판을 벗어나지 않았다면 count를 +1
				count++;
			}
		}
		
		System.out.println(count);
	
	}

}
