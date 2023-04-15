import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        PriorityQueue<Integer> first = new PriorityQueue<>();
        PriorityQueue<Integer> second = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 1; i < food.length; i++) {
            int n = food[i] / 2;
            for(int j = 0; j < n; j++) {
                first.offer(i);
                second.offer(i);
            }
        }
        
        while(!first.isEmpty()) {
            answer += first.poll();
        }
        answer+="0";
        while(!second.isEmpty()) {
            answer += second.poll();
        }
        return answer;
    }
}