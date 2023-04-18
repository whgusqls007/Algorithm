import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        char[] c = String.valueOf(n).toCharArray();
        
        Arrays.sort(c);
        
        answer = Long.parseLong(new StringBuilder(String.valueOf(c)).reverse().toString());
        
        return answer;
    }
}