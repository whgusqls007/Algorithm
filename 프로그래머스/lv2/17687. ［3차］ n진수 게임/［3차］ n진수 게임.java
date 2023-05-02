import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int turn = 1;
        breakPoint : while(sb.length() < t) {
            String str = Integer.toString(num, n);
            for(int i = 0; i < str.length(); i++) {
                if(turn == p) {
                    char c = str.charAt(i);
                    if(Character.isAlphabetic(c)) {
                        c = Character.toUpperCase(c);
                    }
                    sb.append(c);
                    if(sb.length() == t) {
                        break breakPoint;
                    }
                }
                turn++;
                if(turn == m + 1) {
                    turn = 1;
                }
            }
            num++;
        } 
        
        return sb.toString();
    }
}
