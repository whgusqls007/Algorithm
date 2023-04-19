import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (e1, e2) -> Integer.compare(e1[1], e2[1]));
        
        int cnt = 0;
        int lp = 0;
        for(int i = 0; i < targets.length; i++) {
            int s = targets[i][0];
            int e = targets[i][1];
            
            if(lp <= s) {
                lp = e;
                cnt++;
            } else {
                if(e <= lp) {
                    lp = e;
                }
            }
        }
        
        return cnt;
    }
}