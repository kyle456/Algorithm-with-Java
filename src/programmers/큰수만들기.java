package programmers;

import java.util.ArrayList;

public class 큰수만들기 {
	public String solution(String number, int k) {
		// String to Integer
		ArrayList<Integer> intNum = new ArrayList<Integer>(number.length());
		for (int i = 0; i < number.length(); i++) {
			intNum.add(number.charAt(i) - '0');
		}

		int thisIndex = 0;
		int nextIndex = 1;
		while (k > 0) {
			// 뒤 숫자가 크면 앞 숫자 지우고, 다시 처음부터 검사
			if (intNum.get(thisIndex) < intNum.get(nextIndex)) {
				intNum.remove(thisIndex);
				k--;
				thisIndex = 0;
				nextIndex = 1;
				continue;
			}
			// 뒤 숫자가 작으면 지우지 않고 다음 index로 넘어감
			else {
				thisIndex++;
				nextIndex++;
				if (nextIndex > intNum.size() - 1) {
					nextIndex = 0;
				}
				if (thisIndex > intNum.size() - 1) {
					thisIndex = 0;
				}
			}
		}

		// Integer to String
		String answer = "";
		for (int i = 0; i < intNum.size(); i++) {
			answer += Integer.toString(intNum.get(i));
		}

		return answer;
	}

}
