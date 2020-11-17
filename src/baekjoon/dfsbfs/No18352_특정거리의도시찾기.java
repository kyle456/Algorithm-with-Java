package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No18352_특정거리의도시찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<Integer>> city = new ArrayList<ArrayList<Integer>>(); // 도시 그래프
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 도시의 개수
		int m = Integer.parseInt(st.nextToken()); // 도로의 개수
		int k = Integer.parseInt(st.nextToken()); // 최단 거리
		int x = Integer.parseInt(st.nextToken()); // 출발 도시 번호
		int[] visited = new int[n]; // 방문 여부 기록

		// 정점 초기화
		for (int i = 0; i < n; i++) {
			city.add(new ArrayList<Integer>());
		}

		// 각 정점과 이어진 정점 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;

			city.get(start).add(end); // 단방향
		}

		br.close();

		// 각 정점과 이어진 정점들 오름차순 정렬
		for (int i = 0; i < n; i++) {
			Collections.sort(city.get(i));
		}
		
		bfs(x - 1, city, visited);
		boolean isResult = false; // 최단 거리에 해당하는 값이 있는가?
		
		// 최단 거리에 해당하는 정점 출력
		for (int i = 0; i < n; i++) {
			if (visited[i] - 1 == k) {
				System.out.println(i + 1);
				isResult = true;
			}
		}
		
		// 최단 거리에 해당하는 값이 없을 경우 -1 출력
		if(!isResult)
			System.out.println(-1);

	}

	public static void bfs(int x, ArrayList<ArrayList<Integer>> city, int[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(x);
		visited[x] = 1; // 방문 기록

		while (!queue.isEmpty()) {
			x = queue.poll();
			
			for (int i = 0; i < city.get(x).size(); i++) {
				int nextX = city.get(x).get(i);
				if (visited[nextX] == 0) {
					queue.offer(nextX); // 큐에 삽입
					visited[nextX] = visited[x] + 1; // 방문 기록
				}
			}
		}
	}

}
