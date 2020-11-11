package baekjoon.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1697_숨바꼭질 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int subin = sc.nextInt(); // 수빈이 위치
		int sister = sc.nextInt(); // 동생 위치
		int[] line = new int[100001];
		
		// 수빈이가 더 오른쪽에 있는 경우 예외 처리
		if (subin >= sister) {
			System.out.println(subin - sister);
			return;
		}
		
		System.out.println(bfs(subin, sister, line) - 1);
	}
	
	public static int bfs(int subin, int sister, int[] line) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] dx = { -1, 1, subin }; // -1, +1, *2
		queue.offer(subin);
		line[subin] = 1; // 방문 처리
		
		while(!queue.isEmpty()) {
			subin = queue.poll();
			dx[2] = subin; // *2를 해야하므로 자기 자신으로 갱신
			
			for (int i = 0; i < 3; i++) {
				int newSubin = subin + dx[i];
				if (newSubin >= 0 && newSubin < line.length && line[newSubin] == 0) {
					queue.offer(newSubin); // 큐에 추가
					line[newSubin] = line[subin] + 1; // 방문 처리(이동 기록을 유지한 채로)
				}
			}
		}
		
		return line[sister];
	}
}
