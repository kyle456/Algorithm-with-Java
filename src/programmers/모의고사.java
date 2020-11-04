package programmers;

public class 모의고사 {
	public int[] solution(int[] answers) {
		int[] student1 = { 1, 2, 3, 4, 5 };
		int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] student3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int score1 = 0;
		int score2 = 0;
		int score3 = 0;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == student1[i % 5])
				score1++;
			if (answers[i] == student2[i % 8])
				score2++;
			if (answers[i] == student3[i % 10])
				score3++;
		}

		int[] answer = {};
		return answer;
	}

}
