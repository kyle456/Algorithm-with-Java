package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class 두개뽑아서더하기 {
	class Solution {
	    public int[] solution(int[] numbers) {
	        ArrayList<Integer> numberList = new ArrayList<Integer>();

	        for (int i = 0; i < numbers.length; i++) {
	            for (int j = 0; j < numbers.length; j++) {
	                if (i != j && !numberList.contains(numbers[i] + numbers[j]) ) {
	                    numberList.add(numbers[i] + numbers[j]);
	                }
	            }
	        }

	        int[] answer = new int[numberList.size()];
	        for (int i = 0; i < numberList.size(); i++) {
	            answer[i] = numberList.get(i);
	        }
	        Arrays.sort(answer);

	        return answer;
	    }
	}
}
