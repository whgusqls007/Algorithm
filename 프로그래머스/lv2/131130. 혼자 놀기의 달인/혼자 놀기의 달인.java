import java.util.*;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        for(int i = 0; i < cards.length; i++) {
            boolean[] visit1 = new boolean[cards.length];
            int next1 = i;
            int cnt1 = 0;
            while(!visit1[next1]) {
                visit1[next1] = true;
                next1 = cards[next1] - 1;
                cnt1++;
            }
            
            for(int j = 0; j < cards.length; j++) {
                boolean[] visit2 = visit1.clone();
                int next2 = j;
                int cnt2 = 0;
                while(!visit2[next2]) {
                    visit2[next2] = true;
                    next2 = cards[next2] - 1;
                    cnt2++;
                }
                answer = Math.max(answer, cnt1 * cnt2);
            }
        }
        
        return answer;
    }
}