package baekjoon.greedy;

import java.util.Scanner;

public class No1541_잃어버린괄호 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String exp = scanner.nextLine();
		String[] expMinusSplit = exp.split("-");
		int result = 0;
		boolean trigger = true;
		
		for (int i = 0; i < expMinusSplit.length; ++i) {
			String[] eachPlusSplit = expMinusSplit[i].split("\\+");
			int sum = 0;
			
			for(int j = 0; j < eachPlusSplit.length; ++j) {
				sum += Integer.parseInt(eachPlusSplit[j]);
			}
			
			if (trigger) {
				result = sum;
				trigger = false;
			} else {
				result -= sum;
			}
		}
		
		System.out.println(result);
		
	}

}
