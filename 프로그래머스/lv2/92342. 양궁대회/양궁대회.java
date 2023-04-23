import java.util.*;

class Solution {
    int max = 0;
    int[] result;
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        
        int a = 0;
        for(int i = 0; i < info.length; i++) {
            if(info[i] != 0) {
                a += 10 - i;
            }
        }
        
        dfs(info, n, new int[11], 0, a, 0);
        if(max == 0) {
            answer = new int[] {-1};
        } else {
            answer = result;
        }
        return answer;
    }
    
    public void dfs(int[] apeach, int n, int[] lion, int depth, int a, int r) {
        if(depth == n) {
            int score = r - a;
            if(score > 0 & score >= max) {
                max = score;
                result = lion.clone();
            }
            return;
        }
        for(int i = 0; i < 11 && lion[i] <= apeach[i]; i++) {
            lion[i]++;
            if(lion[i] > apeach[i]) {
                if(apeach[i] != 0) {
                    dfs(apeach, n, lion, depth + 1, a - (10 - i), r + (10 - i));
                } else {
                    dfs(apeach, n, lion, depth + 1, a, r + (10 - i));
                }
            } else {
                dfs(apeach, n, lion, depth + 1, a, r);
            }
            lion[i]--;
        }
    }
}