import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        ArrayDeque<Integer> dq1 = new ArrayDeque<>();
        ArrayDeque<Integer> dq2 = new ArrayDeque<>();
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i = 0; i < queue1.length; i++) {
            dq1.offerLast(queue1[i]);
            sum1 += queue1[i];
        }
        
        for(int i = 0; i < queue2.length; i++) {
            dq2.offerLast(queue2[i]);
            sum2 += queue2[i];
        }

        for(int i = 0; i < queue1.length * 6; i++) {
            if(sum1 == sum2) {
                return i;
            }
            else if (sum1 > sum2) {
                int tmp = dq1.pollFirst();
                sum1 -= tmp;
                sum2 += tmp;
                dq2.offerLast(tmp);
            }
            else {
                int tmp = dq2.pollFirst();
                sum1 += tmp;
                sum2 -= tmp;
                dq1.offerLast(tmp);
            }
        }
        
        return -1;
    }
}