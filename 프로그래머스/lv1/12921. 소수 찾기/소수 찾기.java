import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n + 1];
        arr[0] = -1;
        arr[1] = -1;
        
        for(int i = 2; i * i < n + 1; i++) {
            for(int j = i * i; j < n + 1 ; j += i) {
                arr[j] = -1;
            }
        }
        
        answer = (int) Arrays.stream(arr).filter(e1 -> e1 == 0).count();
        return answer;
    }
}