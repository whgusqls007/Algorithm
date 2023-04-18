import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        d = countSorting(d);
        
        int sum = 0;
        for(int i = 0; i < d.length; i++) {
            if(sum + d[i] > budget) {
                break;
            } else {
                sum += d[i];
                answer++;
            }
        }
        
        return answer;
    }
    
    public int[] countSorting(int[] d) {
        int[] count = new int[Arrays.stream(d).max().getAsInt() + 1];
        int[] result = new int[d.length];
        
        for(int i = 0; i < d.length; i++) {
            count[d[i]]++;   
        }
        
        for(int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        
        for(int i = d.length - 1; i > -1; i--) {
            result[--count[d[i]]] = d[i];
        }
            
        return result;
    }
}