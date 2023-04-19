import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[][] points = new int[][] {{-startX, startY}, {startX, -startY}, {m * 2 - startX, startY}, {startX, n * 2 - startY}};
        int[] answer = new int[balls.length];
        
        for(int i = 0; i < balls.length; i++) {
            int x = balls[i][0];
            int y = balls[i][1];
            int min = Integer.MAX_VALUE;
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int[] point : points) {
                int x1 = point[0];
                int y1 = point[1];

                int d1 = (x - x1) * (x - x1) + (y - y1) * (y - y1);
                int d2 = (startX - x1) * (startX - x1) + (startY - y1) * (startY - y1);
                
                if((!((x1 == x && x == startX) || (y1 == y && y == startY)) || d1 > d2)) {
                    min = Math.min(min, d1);
                }
            }
            
            answer[i] = min;
        }
        
        return answer;
    }
}