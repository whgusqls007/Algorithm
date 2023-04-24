import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        long[] arr = new long[(int) (right - left + 1)];
        
        int index = 0;
        for(long i = left; i <= right; i++) {
            arr[index++] = i;
        }
        
        for(int i = 0; i < arr.length; i++) {
            int a = (int) (arr[i] / (long) n);
            int b = (int) (arr[i] % (long) n);
            
            answer[i] = a > b ? a + 1 : b + 1;
        }
        
        return answer;
    }
}