import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < topping.length; i++) {
            int t = topping[i];
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        for(int i = 0; i < topping.length - 1; i++) {
            if(topping.length - i < set.size()) {
                break;
            }
            int t = topping[i];
            set.add(t);
            map.put(t, map.getOrDefault(t, 1) - 1);
            
            if(map.get(t) == 0) {
                map.remove(t);
            }
            
            if(map.size() == set.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}