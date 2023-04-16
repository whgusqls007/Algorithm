import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = Integer.MAX_VALUE;
        int width = Integer.MIN_VALUE;
        int height = Integer.MIN_VALUE;
        
        for(int i = 0; i < sizes.length; i++) {
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            width = Math.max(w, width);
            height = Math.max(h, height);
        }
        
        return answer = width * height;
    }
}