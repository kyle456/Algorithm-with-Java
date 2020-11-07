package programmers;

public class 우테코1번 {
	public int solution(String[] grades, int[] weights, int threshold) {
		int answer = -1234567890;
		int sum = 0; // '고유가중치 x 성적가중치'의 합

		// 성적 가중치 = 성적에 해당하는 index
		String[] gradeWeights = { "F", null, null, "D0", "D+", "C0", "C+", "B0", "B+", "A0", "A+" };

		for (int i = 0; i < grades.length; i++) {
			for (int j = 0; j < gradeWeights.length; j++) {
				if (grades[i].equals(gradeWeights[j])) {
					sum += j * weights[i]; // '고유가중치 x 성적가중치' 더하기
					break;
				}
			}
		}

		answer = sum - threshold;
		return answer;
	}

}
