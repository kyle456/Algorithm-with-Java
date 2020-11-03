package programmers;

import java.util.ArrayList;
import java.util.Scanner;

public class 인쇄순서 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
			
		int n = scanner.nextInt();
		int location = scanner.nextInt();
		ArrayList<Integer> priorities = new ArrayList<Integer>(n);
        int answer = 0;       
        for (int i = 0; i < n; i++) {
            priorities.add(scanner.nextInt());
        }
        
        while (true) {
        	boolean printing = true;
            int outDocument = priorities.get(0);
            
            for (int i = 0; i < priorities.size(); i++) {
                if (outDocument < priorities.get(i)) {
                	priorities.add(outDocument);
                	priorities.remove(0);
                    printing = false;
                    
                    location--;
                    if (location < 0) {
                        location = priorities.size() - 1;
                    }
                    break;
                }
            }
            
            if (printing) {
            	priorities.remove(0);
                answer++;
                
                if (location == 0) {
                    break;
                }
                
                location--;
            }
        }
        
        System.out.println(answer);

	}

}
