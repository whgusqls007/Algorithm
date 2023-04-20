import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        int n = Arrays.stream(tangerine).max().getAsInt();
        int[] tmp = new int[n + 1];
        
        for(int i = 0; i < tangerine.length; i++) {
            tmp[tangerine[i]]++;
        }
        
        Integer[] arr = Arrays.stream(tmp).boxed().toArray(Integer[]::new);
        
        Arrays.sort(arr, Collections.reverseOrder());
        
        int min = 1;
        for(int i = 0; i < arr.length; i++) {
            k -= arr[i];
            if(k <= 0) {
                answer = i + 1;
                break;
            }
        }
        
        return answer;
    }
}