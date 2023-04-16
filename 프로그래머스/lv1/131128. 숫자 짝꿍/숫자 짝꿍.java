import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int length = X.length() > Y.length() ? X.length() : Y.length();
        
        for(int i = 0; i < length; i++) {
            if(i < X.length()) {
                arr1[(int) (X.charAt(i) - '0')]++;
            }
            if(i < Y.length()) {
                arr2[(int) (Y.charAt(i) - '0')]++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 9; i > -1; i--) {
            if(arr1[i] > arr2[i]) {
                while(arr2[i] > 0) {
                    sb.append(i);
                    arr2[i]--;
                }
            } else {
                while(arr1[i] > 0) {
                    sb.append(i);
                    arr1[i]--;
                }
            }
        }
        if(sb.length() == 0) {
            return "-1";
        }
        else if(sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}