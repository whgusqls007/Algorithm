import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int n = String.valueOf(storey).length();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {storey, 0});
        Set<Integer> set = new HashSet<>();
        set.add(storey);
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            if(tmp[0] == 0) {
                answer = tmp[1];
                break;
            }
            for(int i = 1; i <= n + 1; i++) {
                if(tmp[0] % (int) Math.pow(10, i) != 0) {
                    int num = (int) Math.pow(10, i - 1);
                    if(!set.contains(tmp[0] - num)) {
                        q.offer(new int[] {tmp[0] - num, tmp[1] + 1});
                        set.add(tmp[0] - num);
                    }
                    if(!set.contains(tmp[0] + num)) {
                        q.offer(new int[] {tmp[0] + num, tmp[1] + 1});
                        set.add(tmp[0] + num);
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}