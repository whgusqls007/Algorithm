import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int[] totalSum = new int[elements.length + 1];
        for(int i = 1; i < totalSum.length; i++) {
            totalSum[i] = totalSum[i - 1] + elements[i - 1];
            set.add(elements[i - 1]);
        }
        
        // System.out.println("totalSum : " + Arrays.toString(totalSum));
        // System.out.println("set : " + set);
        
        for(int i = 2; i <= elements.length - 1; i++) {
            for(int j = 0; j < totalSum.length; j++) {
                int lt = j;
                int rt = j + i;
                int sum = 0;
                
                if(rt < totalSum.length) {
                    sum = totalSum[rt] - totalSum[lt];
                } else {
                    rt = rt % totalSum.length;
                    sum = totalSum[totalSum.length - 1] - totalSum[lt - 1] + totalSum[rt];
                }
                
                set.add(sum);
            }
        }
        
        set.add(Arrays.stream(elements).sum());
        
        return set.size();
    }
}