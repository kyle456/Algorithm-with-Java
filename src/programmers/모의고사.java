package programmers;

import java.util.ArrayList;

public class 모의고사 {
	public int[] solution(int[] answers) {
		ArrayList<Integer> result = new ArrayList<Integer>(3);
		int[] student1 = { 1, 2, 3, 4, 5 };
		int[] student2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] student3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int score1 = 0;
		int score2 = 0;
		int score3 = 0;

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == student1[i % 5]) score1++;
			if (answers[i] == student2[i % 8]) score2++;
			if (answers[i] == student3[i % 10]) score3++;
		}
		
		int highestScore = Math.max(score1, Math.max(score2, score3));
		
		if (highestScore == score1) result.add(1);
		if (highestScore == score2) result.add(2);
		if (highestScore == score3) result.add(3);

		int[] answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		
		return answer;
	}

}
