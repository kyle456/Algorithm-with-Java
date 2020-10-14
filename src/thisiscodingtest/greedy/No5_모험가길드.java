package thisiscodingtest.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class No5_모험가길드 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 총 모험가의 수
		int[] fear = new int[N]; // 모험가의 공포도
		
		for (int i = 0; i < fear.length; ++i) {
			fear[i] = sc.nextInt();
		}
		
		Arrays.sort(fear);
		int count = 0;
		int group = 0;
		
		for (int i = 0; i < fear.length; ++i) {
			count++; // 그룹으로 넣음
			if(count >= fear[i]) {
				group++; // 한 개 그룹 추가
				count = 0; // 그룹 인원 초기화
			}
		}
		
		System.out.println(group);
	}

}
