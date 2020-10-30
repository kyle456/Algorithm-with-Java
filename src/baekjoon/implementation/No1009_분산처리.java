package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class No1009_분산처리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger tenNum = new BigInteger("10"); // 마지막 처리될 컴퓨터 번호를 알기 위해 나눌 10
				
		int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 수
		
		for (int i = 0; i < t; i++) {
			String[] abSplit = br.readLine().split(" "); // 정수 a b
			
			BigInteger numberA = new BigInteger(abSplit[0]);
			BigInteger numberPow = numberA.pow(Integer.parseInt(abSplit[1])); // a의 b제곱		
			int computer = numberPow.remainder(tenNum).intValue(); // 10으로 나눈 나머지
			
			if (computer == 0) {
				System.out.println(10); // 나머지가 0이면 10번 컴퓨터로 처리
			} else {
				System.out.println(computer); // 나머지 번 컴퓨터로 처리
			}
		}
		
		br.close();
	}

}
