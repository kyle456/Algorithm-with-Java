package baekjoon.dfsbfs;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class No1260_DFS와BFS {
	;
	public static int n, m, v;
	public static int[] visited;
	public static int[][] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 정점의 개수
		m = sc.nextInt(); // 간선의 개수
		v = sc.nextInt(); // 시작할 정점의 번호
		visited = new int[n];
		graph = new int[n][n];
		int start, end;

		for (int i = 0; i < m; i++) {
			start = sc.nextInt() - 1;
			end = sc.nextInt() - 1;
			graph[start][end] = 1;
			graph[end][start] = 1;
		}
	}
	
	public void dfs(int x, int y) {
		// graph를 이중 arraylist로 다시 할 것
	}

}
