import java.util.*;
class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        answer[0] = Arrays.stream(array).max().getAsInt();
        for(int i = 0; i < array.length; i++) {
            if(array[i] == answer[0]) {
                answer[1] = i;
                break;
            }
        }
        return answer;
    }
}