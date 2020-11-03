package programmers;

public class 체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				if (reserve[i] == lost[j]) {
					lost[j] = -1;
					reserve[i] = -1;
					break;
				}
			}
		}

		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				if (reserve[i] - 1 == lost[j] || reserve[i] + 1 == lost[j]) {
					lost[j] = -1;
					break;
				}
			}
		}

		int count = 0;
		for (int i = 0; i < lost.length; i++) {
			if (lost[i] != -1) {
				count++;
			}
		}

		answer = n - count;

		return answer;
	}

}
