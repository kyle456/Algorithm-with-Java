package hufs;

import java.util.Scanner;

public class No2_괄호검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		int one = 0;
		int two = 0;
		
		for (int i = 0; i < n; i++) {
			char temp = str.charAt(i);
			if (temp == '[') {
				one++;
			} else if (temp == ']') {
				two++;
			}
		}
		
		if (one == 0 && two == 0) {
			System.out.println("True");
		} else {
			if (one == two) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}

	}

}
