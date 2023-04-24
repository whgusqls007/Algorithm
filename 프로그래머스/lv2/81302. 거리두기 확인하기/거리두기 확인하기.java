import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        continuePoint: for(int i = 0; i < places.length; i++) {
            for(int j = 0; j < places[i].length; j++) {
                for(int k = 0; k < places[i][j].length(); k++) {
                    if(places[i][j].charAt(k) == 'P') {
                        if(!bfs(places[i], j, k)) {
                            answer[i] = 0;
                            continue continuePoint;
                        }
                        
                    }
                }
            }
            answer[i] = 1;
        }
        
        return answer;
    }
    
    public boolean bfs(String[] places, int y, int x) {
        int[] dy = new int[] {-1, 0, 1, 0};
        int[] dx = new int[] {0, 1, 0, -1};
        
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[] {y, x, 0});
        
        boolean[][] visit = new boolean[5][5];
        visit[y][x] = true;
        
        while(!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int cy = cur[0];
            int cx = cur[1];
            int cnt = cur[2];
            
            for(int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];
                
                if(ny < 0 || nx < 0 || ny > 4 || nx > 4) {
                    continue;
                }
                
                if(visit[ny][nx]) {
                    continue;
                }
                
                if(places[ny].charAt(nx) == 'X') {
                    continue;
                }
                
                if(places[ny].charAt(nx) == 'P') {
                    return false;
                }
                
                if(cnt + 1 > 1) {
                    continue;
                }
                
                dq.offerLast(new int[] {ny, nx, cnt + 1});
                visit[ny][nx] = true;
            }
        }
        
        return true;
    }
}