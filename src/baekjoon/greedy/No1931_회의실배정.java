package baekjoon.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class No1931_회의실배정 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt(); // 회의 개수
		long[][] timeTable = new long[n][2]; // 회의의 시작 시간과 끝 시간
		int maxCount = 0; // 사용하는 회의의 개수

		for (int i = 0; i < n; ++i) {
			timeTable[i][0] = scanner.nextInt(); // 시작
			timeTable[i][1] = scanner.nextInt(); // 끝
		}
		

		int thisIndex = 0;
		int nextIndex = 1;
		int count = 1;

		while (nextIndex < n) {
			if (timeTable[thisIndex][1] <= timeTable[nextIndex][0]) {
				// 전 회의의 끝 시간 <= 다음 회의의 시작 시간
				thisIndex = nextIndex;
				nextIndex++;
				count++; // 사용 회의 개수 1 증가
			} else {
				// 전 회의의 끝 시간 > 다음 회의의 시작 시간
				nextIndex++;
			}
		}

		if (count > maxCount)
			maxCount = count;

		System.out.println(maxCount);

	}

}
