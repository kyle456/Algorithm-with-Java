package programmers;

public class 우테코3번 {
	public int solution(int money, String[] expected, String[] actual) {
		int answer = -1;
		int betting = 100; // 베팅금액

		for (int i = 0; i < expected.length; i++) {
			if (expected[i].equals(actual[i])) {
				// 승
				money += betting;
				betting = 100;
			} else {
				// 패
				money -= betting;
				betting *= 2;
			}

			if (money <= 0) {
				// 돈 다 잃으면 중단
				break;
			} else if (money <= betting) {
				// 돈이 베팅금 이하면 올인
				betting = money;
			}
		}

		answer = money;
		return answer;
	}

}
