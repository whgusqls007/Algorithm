import java.util.*;

class Solution {
    int maxUser = -1;
    int maxCost = -1;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        dfs(emoticons.length, new double[users.length], 0, emoticons, users);
        answer = new int[] {maxUser, maxCost};
        return answer;
    }
    
    public void dfs(int n, double[] u, int depth, int[] emoticons, int[][] users) {
        if(depth == n) {
            int ep = (int) Arrays.stream(u).filter(e -> e == -1).count();
            int sum = (int) Arrays.stream(u).filter(e -> e != -1).sum();
            if(maxUser < ep) {
                maxUser = ep;
                maxCost = sum;
            } else if(maxUser == ep) {
                if(maxCost < sum) {
                    maxCost = sum;
                }
            }
            return;
        }
        // 10%
        double[] c = u.clone();
        for(int i = 0; i < users.length; i++) {
            if(users[i][0] <= 10.0) {
                if(c[i] != -1) {
                    c[i] += (emoticons[depth] * 0.9);
                    if(c[i] >= users[i][1]) {
                        c[i] = -1;
                    }
                }
            }
        }
        dfs(n, c, depth + 1, emoticons, users);
        
        // 20%
        c = u.clone();
        for(int i = 0; i < users.length; i++) {
            if(users[i][0] <= 20.0) {
                if(c[i] != -1) {
                    c[i] += (emoticons[depth] * 0.8);
                    if(c[i] >= users[i][1]) {
                        c[i] = -1;
                    }
                }
            }
        }
        dfs(n, c, depth + 1, emoticons, users);
        
        // 30% 
        c = u.clone();
        for(int i = 0; i < users.length; i++) {
            if(users[i][0] <= 30.0) {
                if(c[i] != -1) {
                    c[i] += (emoticons[depth] * 0.7);
                    if(c[i] >= users[i][1]) {
                        c[i] = -1;
                    }
                }
            }
        }
        dfs(n, c, depth + 1, emoticons, users);
        
        // 40%
        c = u.clone();
        for(int i = 0; i < users.length; i++) {
            if(users[i][0] <= 40.0) {
                if(c[i] != -1) {
                    c[i] += (emoticons[depth] * 0.6);
                    if(c[i] >= users[i][1]) {
                        c[i] = -1;
                    }
                }
            }
        }
        dfs(n, c, depth + 1, emoticons, users);
    }
}