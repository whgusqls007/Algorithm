import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for(int i = 0; i < choices.length; i++) {
            if(choices[i] == 4) continue;
            else if(choices[i] < 4) {
                char feat = survey[i].charAt(0);
                map.put(feat, map.get(feat) + (4 - choices[i]));
            } else {
                char feat = survey[i].charAt(1);
                map.put(feat, map.get(feat) + (choices[i] - 4));
            }
        }
        StringBuilder sb = new StringBuilder();
        
        int R = map.get('R');
        int T = map.get('T');
        if(R < T) {
            sb.append("T");
        } else {
            sb.append("R");
        }
        
        int C = map.get('C');
        int F = map.get('F');
        if(C < F) {
            sb.append("F");
        } else {
            sb.append("C");
        }
        
        int J = map.get('J');
        int M = map.get('M');
        if(J < M) {
            sb.append("M");
        } else {
            sb.append("J");
        }
        
        int A = map.get('A');
        int N = map.get('N');
        if(A < N) {
            sb.append("N");
        } else {
            sb.append("A");
        }
        
        return sb.toString();
    }
}