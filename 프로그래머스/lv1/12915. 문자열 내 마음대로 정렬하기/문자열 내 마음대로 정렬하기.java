import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings);
        int[] count = new int[27];
        for(int i = 0; i < strings.length; i++) {
            count[strings[i].charAt(n) - 97]++;
        }
        
        for(int i = 1; i < 27; i++) {
            count[i] += count[i - 1];
        }
        
        for(int i = strings.length - 1; i > -1; i--) {
            answer[--count[strings[i].charAt(n) - 97]] = strings[i];
        }
        
        return answer;
    }
}