package hufs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1_스페인알파벳 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String spanish = br.readLine();
		int count = 0;
		
		for (int i = 0; i < spanish.length(); i++) {
			char alphabet = spanish.charAt(i);
			
			if (alphabet >= 'a' && alphabet <= 'z') {
				count++;
			}
		}
		
		System.out.println(count);	
	}

}
