import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] c = s.toCharArray();
        Arrays.sort(c);
        answer = new StringBuilder(String.valueOf(c)).reverse().toString();
        return answer;
    }
}