import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    answer[1]++;
                }
            }

            s = s.replaceAll("0", "");

            s = Integer.toString(s.length(), 2);
            answer[0]++;
        }

        return answer;
    }
}