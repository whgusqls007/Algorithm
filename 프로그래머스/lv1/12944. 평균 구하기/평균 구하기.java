import java.util.*;

class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        answer = Arrays.stream(arr).sum() / (double) arr.length;
        return answer;
    }
}