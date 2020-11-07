package programmers;

public class 우테코7번 {
	public int[][] solution(int n, boolean horizontal) {
		int[][] answer = new int[n][n];
		int seconds = 0;
		int nextRow = 0;
		int nextColumn = 0;
		boolean rightDiagonal = true; // 오른쪽 위 방향: true, 왼쪽 아래 방향: false

		for (int i = 1; i < n * n; i++) {
			// 대각선 진행방향에 따른 좌표 이동
			if (rightDiagonal) {
				nextRow--;
				nextColumn++;
			} else {
				nextRow++;
				nextColumn--;
			}

			// 다음 위치가 갈 수 있는지 없는지 판별하고, 방향 변경 및 시간 덧셈
			if (nextRow > n - 1) {
				// 오른쪽 이동
				nextRow--;
				nextColumn += 2;
				rightDiagonal = true;
				seconds++;
			} else if (nextColumn > n - 1) {
				// 아래 이동
				nextColumn--;
				nextRow += 2;
				rightDiagonal = false;
				seconds++;
			} else if (nextRow < 0) {
				// 오른쪽 이동
				nextRow++;
				rightDiagonal = false;
				seconds++;
			} else if (nextColumn < 0) {
				// 아래 이동
				nextColumn++;
				rightDiagonal = true;
				seconds++;
			} else {
				// 대각 이동
				seconds += 2;
			}

			answer[nextRow][nextColumn] = seconds; // 도착 시간 대입
		}

		if (horizontal) {
			// 처음에 오른쪽으로 이동 했을 경우 그대로 출력
			return answer;
		} else {
			// 처음에 아래쪽으로 이동 했을 경우 결과값 조정
			int[][] otherAnswer = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					otherAnswer[i][j] = answer[j][i];
				}
			}
			return otherAnswer;
		}
	}

}
