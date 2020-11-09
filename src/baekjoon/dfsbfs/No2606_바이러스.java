package baekjoon.dfsbfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2606_바이러스 {
	public static int computers, pairs, count;
	public static boolean visited[];
	public static ArrayList<ArrayList<Integer>> network = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		computers = sc.nextInt();
		pairs = sc.nextInt();
		count = 0;
		visited = new boolean[computers];
		
		for (int i = 0; i < computers; i++) {
			network.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < pairs; i++) {
			int left = sc.nextInt() - 1;
			int right = sc.nextInt() - 1;
			network.get(left).add(right);
			network.get(right).add(left);
		}
		
		for (int i = 0; i < computers; i++) {
			Collections.sort(network.get(i));
		}
		
		dfs(0);
		System.out.println(count - 1); // 1번 컴퓨터는 제외하므로 -1
		
		count = 0;
		visited = new boolean[computers];
		bfs(0);
		System.out.println(count - 1); // 1번 컴퓨터는 제외하므로 -1
	}
	
	public static void dfs(int x) {
		visited[x] = true;
		count++;
		
		for (int i = 0; i < network.get(x).size(); i++) {
			int y = network.get(x).get(i);
			if (!visited[y]) {
				dfs(y);
			}
		}
	}
	
	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		visited[x] = true;
		
		while(!queue.isEmpty()) {
			x = queue.poll();
			count++;
			
			for (int i = 0; i < network.get(x).size(); i++) {
				int y = network.get(x).get(i);
				if (!visited[y]) {
					queue.offer(y);
					visited[y] = true;
				}
			}
		}
	}

}
