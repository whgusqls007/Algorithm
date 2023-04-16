import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        for(int i = 0; i < sb.length(); i++) {
            int c = sb.charAt(i) - '0';
            if(c == 0) {
                continue;
            }
            answer += Math.pow(3, i) * c;
        }
        
        return answer;
    }
}