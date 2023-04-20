import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        int a = Arrays.stream(arrayA).min().getAsInt();
        int b = Arrays.stream(arrayB).min().getAsInt();
        int max = -1;
        
        continuePoint : for(int i = a; i > 1; i--) {
            for(int j = 0; j < arrayA.length; j++) {
                if(arrayA[j] % i != 0) {
                    continue continuePoint;
                }
            }
            
            for(int j = 0; j < arrayB.length; j++) {
                if(arrayB[j] % i == 0) {
                    continue continuePoint;
                }
            }
            max = i;
            break;
        }
        
        continuePoint : for(int i = b; i > 1; i--) {
            for(int j = 0; j < arrayB.length; j++) {
                if(arrayB[j] % i != 0) {
                    continue continuePoint;
                }
            }
            
            for(int j = 0; j < arrayA.length; j++) {
                if(arrayA[j] % i == 0) {
                    continue continuePoint;
                }
            }
            max = Math.max(max, i);
            break;
        }
        
        return max == -1 ? 0 : max;
    }
}