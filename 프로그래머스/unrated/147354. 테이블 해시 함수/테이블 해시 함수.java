import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (e1, e2) -> Integer.compare(e1[col - 1], e2[col - 1]) == 0 ? -Integer.compare(e1[0], e2[0]) : Integer.compare(e1[col - 1], e2[col - 1]));
        
        List<Integer> si = new ArrayList<>();
        
        for(int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for(int j = 0; j < data[i].length; j++) {
                sum += data[i][j] % (i + 1);
            }
            si.add(sum);
        }
        int num = si.get(0);
        for(int i = 1; i < si.size(); i++) {
            num = num ^ si.get(i);
        }
        
        return num;
    }
}