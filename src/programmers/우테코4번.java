package programmers;

public class 우테코4번 {
	public int solution(int n, int[][] board) {
		int[] start = { 0, 0 }; // 시작 지점(최초는 왼쪽 위)
		int[] arrive = new int[2]; // 도착 지점
		int count = 0; // 키를 누른 횟수

		// 1부터 n제곱 까지 지우기
		for (int i = 1; i <= n * n; i++) {
			// 도착 지점 찾기
			for (int x = 0; x < n; x++) {
				for (int y = 0; y < n; y++) {
					if (board[x][y] == i) {
						arrive[0] = x;
						arrive[1] = y;
					}
				}
			}

			// x좌표 최적 이동 횟수 탐색
			if (start[0] <= arrive[0]) {
				count += Math.min(arrive[0] - start[0], start[0] + n - arrive[0]);
			} else {
				count += Math.min(start[0] - arrive[0], arrive[0] + n - start[0]);
			}

			// y좌표 최적 이동 횟수 탐색
			if (start[1] <= arrive[1]) {
				count += Math.min(arrive[1] - start[1], start[1] + n - arrive[1]);
			} else {
				count += Math.min(start[1] - arrive[1], arrive[1] + n - start[1]);
			}

			count += 1; // 엔터
			
			// 시작 지점 갱신
			start[0] = arrive[0];
			start[1] = arrive[1];
		}

		return count;
	}

}
