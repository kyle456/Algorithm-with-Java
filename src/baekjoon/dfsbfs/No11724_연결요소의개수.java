package baekjoon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No11724_연결요소의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>(); // 그래프
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점의 개수
		int m = Integer.parseInt(st.nextToken()); // 간선의 개수
		boolean[] visited = new boolean[n]; // 방문 기록
		int count = 0; // 연결 요소의 개수 (출력값)
		
		// 정점 기록
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		// 각 정점마다 간선으로 이어진 정점 기록
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken()) - 1;
			int right = Integer.parseInt(st.nextToken()) - 1;
			
			graph.get(left).add(right);
			graph.get(right).add(left);
		}
		
		// 각 정점마다 이어진 정점을 깊이 우선 탐색
		for (int i = 0; i < n; i++) {
			if (!visited[i] && dfs(i, graph, visited)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
		if (visited[node]) {
			return false; // 이미 방문한 경우 false
		} else {
			visited[node] = true; // 방문 기록
			for (int i = 0; i < graph.get(node).size(); i++) {
				dfs(graph.get(node).get(i), graph, visited);
			}
			return true;
		}
	}

}
