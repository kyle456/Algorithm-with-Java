package programmers;

public class 큰수만들기 {
    public String solution(String number, int k) {        
        String answer = "";
        StringBuilder sbNum = new StringBuilder(number);
        
        int thisIndex = 0;
        int nextIndex = 1;
        int lastIndex;
        while(k > 0) {
            // 뒤 숫자가 크면 앞 숫자 지우고, 다시 처음부터 검사
            if (sbNum.charAt(thisIndex) < sbNum.charAt(nextIndex)) {
                sbNum.deleteCharAt(thisIndex);
                k--;
                thisIndex = 0;
                nextIndex = 1;
            } 
            // 뒤 숫자가 작으면 지우지 않고 다음 index로 넘어감
            else {
                thisIndex++;
                nextIndex++;
                lastIndex = sbNum.length() - 1;
                if (nextIndex > lastIndex) {
                    nextIndex = 0;
                }
                if (thisIndex > lastIndex) {
                    thisIndex = 0;
                }
            }
        }        
        
        answer = sbNum.toString();
        
        return answer;
    }
}