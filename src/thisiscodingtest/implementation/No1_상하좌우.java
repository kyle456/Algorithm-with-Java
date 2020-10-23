package thisiscodingtest.implementation;

import java.util.Scanner;

public class No1_상하좌우 {
	private static final String DIRECTIONS = "LRUD";
	private static final int[] MOVE = { -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // 공간의 크기
		scanner.nextLine();
		String plans = scanner.nextLine(); // 이동할 방향
		String[] plansSplit = plans.split(" ");
		
		int[] location = new int[2]; // 현재 위치 (location[0]: column, location[1]: row, 출발점은 0,0)
		
		for (int i = 0; i < plansSplit.length; i++) {
			// R이 입력될 경우, DIRECTIONS에서 몇 번째에 R이 위치하는지 반환, 이것은 곧 MOVE의 인덱스로 입력
			int indexOfMOVE = DIRECTIONS.indexOf(plansSplit[i]);
			
			// MOVE에서 0,1인덱스는 location에서 가로 방향, 2,3인덱스는 location에서 세로 방향이기 때문에
			// indexOfMOVE / 2를 한 값을 location의 인덱스로 넣음, 그리고 방향에 맞게 이동
			location[indexOfMOVE / 2] += MOVE[indexOfMOVE];
			
			if (location[indexOfMOVE / 2] < 0 || location[indexOfMOVE / 2] > n) {
				// 지도 바깥으로 넘어간 경우, 원래 값으로 되돌림
				location[indexOfMOVE / 2] -= MOVE[indexOfMOVE];
			}
		}
		
		System.out.println((location[1] + 1) + " " + (location[0] + 1)); // row, column 순으로 고쳐서 출력
	}

}
