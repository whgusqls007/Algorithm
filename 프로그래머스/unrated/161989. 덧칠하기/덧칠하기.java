import java.util.*;
class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < section.length; i++) {
            set.add(section[i]);
        }
        for(int i = 1; i <= n; i++) {
            if(set.contains(i)) {
                i += m - 1;
                answer++;
            }
        }
        return answer;
    }
}