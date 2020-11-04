package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 소수찾기 {
	
	public static ArrayList<Integer> answer = new ArrayList<Integer>(); // 판별된 소수 집합

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String numbers = scanner.nextLine();
		
		// String to Integer
		int[] intNum = new int[numbers.length()];
		for (int i = 0; i < intNum.length; i++) {
			intNum[i] = numbers.charAt(i) - '0';
		}

		for (int i = 1; i <= intNum.length; i++) {
			int[] res = new int[i];
			perm(intNum, 0, intNum.length, res);
		}
		
		System.out.println(answer.size());

	}
	
	// 스왑
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	// 순열 & 소수 판별
	public static void perm(int[] arr, int depth, int n, int[] res) {
		if (depth == res.length) {
			int checkNum = Integer.parseInt(Arrays.toString(res).replaceAll("[^0-9]","")); // Array to Integer
			if (checkPrime(checkNum))	{
				for (int i = 0; i < answer.size(); i++) {
					if (checkNum == answer.get(i)) // 중복 방지
						return;
				}
				answer.add(checkNum);
			}
			return;
		}

		for (int i = depth; i < n; i++) {
			swap(arr, depth, i);
			res[depth] = arr[depth];
			perm(arr, depth + 1, arr.length, res); // 재귀 호출
			swap(arr, depth, i); // 복원
		}
	}

	// 에라토스테네스의 체(소수 판별)
	public static boolean checkPrime(int number) {
		if (number < 2)
			return false;
		else {
			for (int i = 2; i <= (int) Math.sqrt(number); i++) {
				if (number % i == 0)
					return false;
			}
			return true;
		}
	}

}
