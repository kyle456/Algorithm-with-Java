package programmers;

public class 우테코5번 {
	public String solution(String penter, String pexit, String pescape, String data) {
		StringBuilder dataPackage = new StringBuilder(); // data 포장
		String segment = ""; // data 내부 원소
		int start = 0;
		int end = penter.length();

		dataPackage.append(penter); // penter 삽입

		// data 포장하기
		for (int i = 1; i <= data.length() / penter.length(); i++) {
			segment = data.substring(start, end);

			if (segment.equals(penter) || segment.equals(pexit) || segment.equals(pescape)) {
				// penter, pexit, pescape와 동일하면 pescape 삽입
				dataPackage.append(pescape);
			}

			dataPackage.append(segment);
			start = end;
			end += penter.length();
		}

		dataPackage.append(pexit); // pexit 삽입

		String answer = dataPackage.toString();
		return answer;
	}

}
