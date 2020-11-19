package thisiscodingtest.implementation;

import java.util.Scanner;

public class No4_게임개발 {
	// 방향이 배열의 index로 들어가서(북, 동, 남, 서), 각 방향에 따라 왼쪽으로 이동할 때의 N과 M의 변화
	private static final int[] LEFTN = { 0, -1, 0, 1 };
	private static final int[] LEFTM = { -1, 0, 1, 0 };
	
	// 방향이 배열의 index로 들어가서(북, 동, 남, 서), 각 방향에 따라 뒤로 이동할 때의 N과 M의 변화
	private static final int[] BACKN = { 1, 0, -1, 0 };
	private static final int[] BACKM = { 0, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt(); // 세로 크기
		int m = scanner.nextInt(); // 가로 크기
		
		int[] location = new int[2]; // 캐릭터의 현재 위치
		location[0] = scanner.nextInt(); // 북쪽으로 부터 몇 칸
		location[1] = scanner.nextInt(); // 서쪽으로 부터 몇 칸
		
		int nowDirection = scanner.nextInt(); // 캐릭터의 현재 방향

		int[][] map = new int[n][m]; // N x M 맵

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = scanner.nextInt(); // 맵 입력
			}
		}
		
		int countLook = 0; // 회전 하는 수 (4가 되면 갈 곳이 없다는 것이다)
		int visit = 1; // 방문한 칸의 수 (처음 시작하는 칸을 포함하므로 1로 시작)
		map[location[0]][location[1]] = 2; // 처음 시작하는 칸도 방문한 것이니 2로 변경
		
		while (true) {
			int lookLeftN = location[0] + LEFTN[nowDirection];
			int lookLeftM = location[1] + LEFTM[nowDirection];
			countLook++;
			
			nowDirection = changeDirection(nowDirection); // 회전
			
			// 안 가본 곳
			if(map[lookLeftN][lookLeftM] == 0) {							
				// 전진
				location[0] = lookLeftN;
				location[1] = lookLeftM;
				
				map[location[0]][location[1]] = 2; // 가본 곳은 2로 표시		
				countLook = 0;
				visit++;
			} 
			// 가봤거나 바다인 곳
			else {	
				// 다 가봤거나 다 바다라서 갈 곳이 없음
				if (countLook == 4) {
					int lookBackN = location[0] + BACKN[nowDirection];
					int lookBackM = location[1] + BACKM[nowDirection];
					
					// 뒤가 바다가 아니라 그냥 가본 곳이다, 그럼 뒤로 이동
					if (map[lookBackN][lookBackM] == 2) {
						location[0] = lookBackN;
						location[1] = lookBackM;
						countLook = 0;
					} 
					// 뒤가 바다다, 그럼 종료
					else {
						break;
					}	
				}
			}
			
		}
		
		System.out.println(visit);

	}
	
	// 왼쪽으로 방향 회전하는 함수
	public static int changeDirection(int nowDirection) {
		nowDirection--;
		if (nowDirection < 0)
			nowDirection = 3;
		
		return nowDirection;
	}
}
