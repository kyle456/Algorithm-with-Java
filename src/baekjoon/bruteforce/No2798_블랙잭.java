package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2798_블랙잭 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 카드의 개수
		int m = Integer.parseInt(st.nextToken()); // 기준 값
		int[] cards = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		int max = 0; // 기준 값에 근접한 최대 값
		
		// 완전탐색을 위한 3중 for문
		loop: for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int temp = cards[i] + cards[j] + cards[k];
					if (temp < m) {
						max = Math.max(max, temp);
					} else if (temp == m) {
						max = temp;
						break loop; // 최대값이 기준값과 같다면 break
					}
				}
			}
		}
		
		System.out.println(max);
	}

}
