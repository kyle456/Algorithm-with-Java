package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1946_신입사원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		int[] maxNewCommer = new int[t]; // 각 테스트 케이스의 최대 선발 신입사원 수		
		
		for (int i = 0; i < t; ++i) {
			int n = Integer.parseInt(br.readLine()); // 각 테스트 케이스의 지원자 수
			int[] grade = new int [n + 1]; // 지원자의 성적
			
			for (int j = 0; j < n; ++j) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				grade[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken()); // 서류 점수를 기준으로 오름차순으로 정렬한 것과 같은 효과
			}
			
			int bound = grade[1]; // bound는 현재 지원자 보다 높은 서류 점수 지원자들 중 가장 높은 면접 점수를 의미
			
			for (int x = 2; x <= n; ++x) {
				if (bound > grade [x]) {
					bound = grade[x]; // bound 보다 높은 면접 점수를 다시 bound로 삽입
					maxNewCommer[i]++; // 면접 점수가 높으므로 선발 + 1
				}
			}
		}
		
		br.close();
		
		// 선발할 수 있는 신입사원의 최대 인원수 출력(결과값)
		for (int i = 0; i < t; ++i) {
			System.out.println(maxNewCommer[i] + 1); // +1을 하는 이유는 서류 점수 1등을 넣기 위함
		}
	}

}
