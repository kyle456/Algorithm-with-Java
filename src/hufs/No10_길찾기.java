package hufs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x, y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class No10_길찾기 {
	static int n;
	static int[][] map;
	static int[] dx = { 0, 1, 0, 2 };
	static int[] dy = { 1, 0, 2, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()) + 1;
		br.close();
		map = new int[n][n];
		bfs(0,0);
		System.out.println(map[n-1][n-1]);
	}
	
	public static void bfs(int x, int y) {	
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x, y));
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = point.x + dx[i];
				int newY = point.y + dy[i];
				
				if (newX < n && newY < n) {
					queue.offer(new Point(newX, newY));
					map[newX][newY]++;
				}
			}
		}
	}

}
