import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int N = park.length;
        int M = park[0].length();
        char[][] arr = new char[N][M];
        int y = 0;
        int x = 0;
        
        for(int i = 0; i < N; i++) {
            arr[i] = park[i].toCharArray();
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 'S') {
                    y = i;
                    x = j;
                    arr[i][j] = 'O';
                }
            }
        }
        
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        
        continuePoint : for(int i = 0; i < routes.length; i++) {
            String[] order = routes[i].split(" ");
            
            int dir = 0;
            switch(order[0]) {
                case "N":
                    dir = 0;
                    break;
                case "E":
                    dir = 1;
                    break;
                case "S":
                    dir = 2;
                    break;
                default:
                    dir = 3;
                    break;
            }
            int cnt = Integer.parseInt(order[1]);
            int cy = y;
            int cx = x;
            for(int j = 0; j < cnt; j++) {
                int ny = cy + dy[dir];
                int nx = cx + dx[dir];
                if(ny < 0 || nx < 0 || ny > N - 1 || nx > M - 1) {
                    continue continuePoint;
                }
                if(arr[ny][nx] == 'X') {
                    continue continuePoint;
                }
                cy = ny;
                cx = nx;
            }
            
            y = cy;
            x = cx;
        }
        answer = new int[2];
        answer[0] = y;
        answer[1] = x;
        return answer;
    }
}