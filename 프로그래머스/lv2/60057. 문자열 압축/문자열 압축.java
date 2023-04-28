import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 1000;
        if(s.length() == 1) {
            answer = 1;
            return answer;
        }
        for(int i = 1; i <= s.length() / 2; i++) {
            
            int cnt = 1;
            StringBuilder sb = new StringBuilder();
            String pre = s.substring(0, i);
            
            for(int j = i; j < s.length(); j += i) {
                String str;
                if(j + i > s.length()) {
                    str = s.substring(j, s.length());
                } else {
                    str = s.substring(j, j + i);    
                }
                // System.out.println(pre);
                // System.out.println(str);
                // System.out.println();
                if(pre.equals(str)) {
                    cnt++;
                } else {
                    if(cnt == 1) {
                        sb.append(pre);
                    } else {
                        sb.append(cnt);
                        sb.append(pre);
                    }
                    cnt = 1;
                }
                pre = str;
                
            }
            
            if(cnt == 1) {
                sb.append(pre);
            } else {
                sb.append(cnt);
                sb.append(pre);
            }
            // System.out.println(sb.toString());
            // System.out.println();
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}