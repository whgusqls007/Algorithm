// import java.util.*;

class Solution {
    public int[] solution(long n) {
        char[] c = new StringBuilder(String.valueOf(n)).reverse().toString().toCharArray();
        int[] answer = new int[c.length];
        for(int i = 0; i < c.length; i++) {
            answer[i] = (int) c[i] - '0';
        }
        return answer;
    }
}