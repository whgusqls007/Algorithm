import java.util.*;

class Solution {
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    char[] arr;
    char[] chr = {'d', 'l', 'r', 'u'};
    ArrayList<String> arrayList = new ArrayList<>();
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        arr = new char[k];
        if(dfs(n, m, x, y, r, c, k, 0)) {
            answer = new String(arr);            
        } else {
            answer = "impossible";
        }
        return answer;
    }
    
    public boolean dfs(int n,int m, int x, int y, int r, int c, int k, int index) {
        if(index == k && x == r && y == c) {
            return true;
        } else if(index == k && (x != r || y != c)) {
            return false;
        } else if(!isReachable(x, y, r, c, k - index)) {
            return false;
        }
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 1 || ny < 1 || nx > n || ny > m) {
                continue;
            }
            
            arr[index] = chr[i];

            if(dfs(n, m, nx, ny, r, c, k, index + 1)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isReachable(int x, int y, int r, int c, int cnt) {
        int dist = getDistance(x, y, r, c);
        if(cnt < dist || (cnt - dist) % 2 == 1) {
            return false;
        }
        return true;
    }
    
    public int getDistance(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
}