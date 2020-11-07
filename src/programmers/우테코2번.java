package programmers;

public class 우테코2번 {
	public long[] solution(String s, String op) {
		long[] answer = new long[s.length() - 1];
		long left = 0; // 왼쪽
		long right = 0; // 오른쪽

		for (int i = 1; i <= s.length() - 1; i++) {
			left = Long.parseLong(s.substring(0, i));
			right = Long.parseLong(s.substring(i, s.length()));

			// 연산자에 따라 다른 계산
			switch (op) {
			case "+":
				answer[i - 1] = left + right;
				break;
			case "-":
				answer[i - 1] = left - right;
				break;
			case "*":
				answer[i - 1] = left * right;
				break;
			}
		}

		return answer;
	}

}
