package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1744_수묶기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 수열의 크기
		int[] numArr = new int[n];
		
		for (int i = 0; i < n; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		Arrays.sort(numArr);
		
		// 정렬 후 0이나 음수가 나오는 구간을 기록
		// 그 구간을 중심으로 왼쪽(음수), 오른쪽(양수)로 나누어서 끝에서부터 2개씩 묶으면 됨
		// 묶는 개수는 음수 or 양수의 개수를 2로 나눈 몫 만큼임
		// 묶지 못한 나머지 수들은 그냥 더함
	}

}
