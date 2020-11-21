package hufs;

import java.util.Scanner;

public class No2_괄호검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		boolean pair = false;
		boolean result = false;

		for (int i = 0; i < n; i++) {
			char temp = str.charAt(i);
			
			if (temp == '[') {
				pair = true;
			} else if (temp == ']') {
				if (!pair) {
					result = false;
					break;
				} else {
					result = true;
					pair = false;
				}
			}
		}

		if (result) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}

	}

}
