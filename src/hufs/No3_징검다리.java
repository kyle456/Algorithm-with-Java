package hufs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class No3_징검다리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> zero = new ArrayList<Integer>();
		int n = Integer.parseInt(br.readLine());
		int[] bridge = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			bridge[i] = Integer.parseInt(st.nextToken());
			if (bridge[i] == 0) {
				zero.add(i);
			}
		}
		
		if (zero.size() == 0) {
			System.out.println("True");
			return;
		}
		
		
		for (int i = 0; i < zero.size(); i++) {
			int start = 0;
			int end = zero.get(0);
			int temp = 0;
			
			for (int j = start; j < end; j++) {
				temp += bridge[start];
				if (temp > end) {
					break;
				}
			}
		}
		
		
	}

}
