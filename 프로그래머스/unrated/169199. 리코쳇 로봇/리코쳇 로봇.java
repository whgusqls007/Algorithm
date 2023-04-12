import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        int N = board.length;
        int M = board[0].length();
        
        char[][] arr = new char[N][M];
        int y = 0;
        int x = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = board[i].toCharArray();
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 'R') {
                    y = i;
                    x = j;
                }
            }
        }
        
        return bfs(y, x, N, M, arr);
    }
    
    public int bfs(int y, int x, int N, int M, char[][] arr) {
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{y, x, 0});
        boolean[][] visit = new boolean[N][M];
        visit[y][x] = true;
        
        while(!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int cy = cur[0];
            int cx = cur[1];
            int cnt = cur[2];

            for(int i = 0; i < 4; i++) {
                cy = cur[0];
                cx = cur[1];
                
                while(true) {
                    int ny = cy + dy[i];
                    int nx = cx + dx[i];
                    
                    if(ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1 || arr[ny][nx] == 'D') {
                        if(arr[cy][cx] == 'G') {
                            return cnt + 1;
                        }
                        if(!visit[cy][cx]) {
                            dq.offerLast(new int[] {cy, cx, cnt + 1});
                            visit[cy][cx] = true;
                        }
                        break;
                    }
                    
                    cy = ny;
                    cx = nx;
                }
            }
        }
        return -1;
    }
}