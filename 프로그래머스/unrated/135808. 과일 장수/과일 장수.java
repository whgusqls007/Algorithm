import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < score.length; i++) {
            pq.offer(score[i]);
        }
        int min = 10;
        int cnt = 0;
        while(!pq.isEmpty()) {
            min = Math.min(pq.poll(), min);
            cnt++;
            
            if(cnt == m) {
                answer += min * m;
                cnt = 0;
                min = 10;
                if(pq.size() < m) {
                    break;
                }
            }
        }
        
        return answer;
    }
}