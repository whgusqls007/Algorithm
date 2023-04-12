import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int[] negative = new int[sequence.length];
        int[] positive = new int[sequence.length];
        int purse = -1;
        
        for(int i = 0; i < sequence.length; i++) {
            negative[i] = purse * sequence[i];
            positive[i] = -purse * sequence[i];
            purse *= -1;
        }
      
        long max = Long.MIN_VALUE;
        long tmpSum1 = 0;
        long tmpSum2 = 0;
        long tmpMax1 = 0;
        long tmpMax2 = 0;
        for(int i = 0; i < sequence.length; i++) {
            tmpSum1 += negative[i];
            tmpSum2 += positive[i];
            
            if(tmpSum1 < 0) {
                tmpSum1 = 0;
            } else {
                tmpMax1 = Math.max(tmpSum1, tmpMax1);
            }
            
            if(tmpSum2 < 0) {
                tmpSum2 = 0;
            } else {
                tmpMax2 = Math.max(tmpSum2, tmpMax2);
            }
            
            max = Math.max(max, Math.max(tmpMax1, tmpMax2));
        }
        
        return max;
    }
}
        