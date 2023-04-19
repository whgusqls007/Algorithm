import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        
        for(int i = 0; i < weights.length; i++) {
            double w = (double) weights[i];
            
            answer += map.getOrDefault(w, 0);
            answer += map.getOrDefault(w / 2, 0) + map.getOrDefault(w * 2, 0);
            answer += map.getOrDefault(w * 2 / 3, 0) + map.getOrDefault(w * 3 / 2, 0);
            answer += map.getOrDefault(w * 3 / 4, 0) + map.getOrDefault(w * 4 / 3, 0);
            
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        
        return answer;
    }
}