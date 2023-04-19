import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Stack<Integer> d = new Stack<>();
        Stack<Integer> p = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < deliveries[i]; j++) {
                d.push(i + 1);
            }
            
            for(int j = 0; j < pickups[i]; j++) {
                p.push(i + 1);
            }
        }
        
        while(!d.isEmpty() || !p.isEmpty()) {
            if(!d.isEmpty() && p.isEmpty()) {
                answer += d.peek() * 2L;
                for(int i = 0; i < cap; i++) {
                    if(!d.isEmpty()) {
                        d.pop();
                    } else {
                        break;
                    }
                }
            } else if(d.isEmpty() && !p.isEmpty()) {
                answer += p.peek() * 2L;
                for(int i = 0; i < cap; i++) {
                    if(!p.isEmpty()) {
                        p.pop();
                    } else {
                        break;
                    }
                }
            } else {
                answer += d.peek() > p.peek() ? d.peek() * 2L : p.peek() * 2L;
                for(int i = 0; i < cap; i++) {
                    if(!d.isEmpty()) d.pop();
                    if(!p.isEmpty()) p.pop();
                }
            }
        }
        
        return answer;
    }
}