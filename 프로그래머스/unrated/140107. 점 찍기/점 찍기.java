import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i = 0; i <= d; i += k) {
            int y = (int) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            answer += (y / k) + 1;
        }
        
        // r^2 = x^2 + y^2;
        // d^2 = x^2 + y^2;
        // 4^2 = 2^2 + y^2;
        // 16 = 4 + y^2;
        // y = 12^(1/2)
        // y = (d^2 - x^2)^(1/2)
        return answer;
    }
}