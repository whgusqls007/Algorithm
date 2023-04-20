import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 1; i <= order.length; i++) {
            q.offer(i);
        }
        
        int index = 0;
        continuePoint : while(true) {
            if(index >= order.length) {
                break;
            }
            int num = order[index];
            
            if(!s.isEmpty() && s.peek() == num) {
                index++;
                s.pop();
                continue;
            }
            
            while(!q.isEmpty() && q.peek() != num) {
                s.push(q.poll());
            }
            
            if(q.isEmpty()) {
                break;
            } else {
                q.poll();
                index++;
            }
        }
        
        return index;
    }
}