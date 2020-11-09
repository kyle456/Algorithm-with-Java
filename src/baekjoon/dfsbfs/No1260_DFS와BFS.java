package baekjoon.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1260_DFS와BFS {
	public static int n, m, v;
	public static boolean[] visited;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 정점의 개수
		m = sc.nextInt(); // 간선의 개수
		v = sc.nextInt(); // 시작할 정점의 번호
		visited = new boolean[n];

		// graph 초기화
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// graph 기록
		for (int i = 0; i < m; i++) {
			int left = sc.nextInt() - 1;
			int right = sc.nextInt() - 1;
			
			// 양방향 기록
			graph.get(left).add(right);
			graph.get(right).add(left);
		}
		
		// 각 노드의 인접노드 오름차순 정렬
		for (int i = 0; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}

		dfs(v - 1);
		System.out.println();
		
		visited = new boolean[n];
		bfs(v - 1);
		System.out.println();
	}

	public static void dfs(int x) {
		visited[x] = true;
		System.out.print(x + 1 + " "); // 방문 노드 출력(노드 번호가 -1 되어있으므로 +1)

		for (int i = 0; i < graph.get(x).size(); i++) {
			int y = graph.get(x).get(i);
			if (!visited[y]) {
				dfs(y); // 방문하지 않았다면 재귀 호출
			}
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		visited[x] = true;
		
		while (!queue.isEmpty()) {
			x = queue.poll();
			System.out.print(x + 1 + " "); // 방문 노드 출력(노드 번호가 -1 되어있으므로 +1)
			
			for (int i = 0; i < graph.get(x).size(); i++) {
				int y = graph.get(x).get(i);
				if (!visited[y]) {
					queue.offer(y); // 방문하지 않았다면 큐에 추가
					visited[y] = true;
				}
			}
		}
	}

}
