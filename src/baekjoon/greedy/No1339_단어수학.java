package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1339_단어수학 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine()); // 단어의 개수
		String[] word = new String[n]; // 각 단어
		
		for (int i = 0; i < n; ++i) {
			word[i] = br.readLine(); // 단어 1줄 씩 입력
		}
		
		br.close();
	}

}
