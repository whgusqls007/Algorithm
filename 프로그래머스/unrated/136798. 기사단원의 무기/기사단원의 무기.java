import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] cnt = new int[number + 1];
        cnt[1] = 1;
        for(int i = 2; i < number + 1; i++) {
            int n = (int) Math.sqrt(i);
            for(int j = 1; j <= n; j++) {
                if( i % j == 0 ) {
                    if(j * j == i) {
                        cnt[i]++;
                    } else {
                        cnt[i] += 2;   
                    }
                }
            }
        }
        
        for(int i = 1; i < cnt.length; i++) {
            if(cnt[i] <= limit) {
                answer += cnt[i];
            } else {
                answer += power;
            }
        }
        
        return answer;
    }
}