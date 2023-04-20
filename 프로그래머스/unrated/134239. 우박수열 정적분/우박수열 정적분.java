import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        ArrayList<Integer> list = new ArrayList<>();
        list.add(k);
        while(k > 1) {
            if((k & 1) == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
            list.add(k);
        }
        
        double[] area = new double[list.size()];
        
        for(int i = 1; i < list.size(); i++) {
            area[i] = ((list.get(i) + list.get(i - 1)) / 2.0) + area[i - 1];
        }

        // System.out.println(Arrays.toString(area));
        
        for(int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = list.size() + ranges[i][1] - 1;
            // System.out.println(start + " " + end);
            
            if(end == start) {
                answer[i] = 0.0;
            } else if(end < start) {
                answer[i] = -1.0;
            } else {
                answer[i] = area[end] - area[start];
            }
        }
        
        return answer;
    }
}