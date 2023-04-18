import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        for(char c : new StringBuilder(String.valueOf(n)).toString().toCharArray()) {
            answer += (int) c - '0';
        }

        return answer;
    }
}