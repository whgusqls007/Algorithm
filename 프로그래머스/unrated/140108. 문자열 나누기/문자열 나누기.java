import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char c = '0';
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(c == '0') {
                c = s.charAt(i);
                cnt1 = 1;
                continue;
            }
            
            if(s.charAt(i) == c) {
                cnt1++;
            } else {
                cnt2++;
            }
            
            if(cnt1 == cnt2) {
                answer++;
                c = '0';
                cnt1 = 0;
                cnt2 = 0;
            }
        }
        if(cnt1 != 0) {
            answer++;
        } 
        return answer;
    }
}