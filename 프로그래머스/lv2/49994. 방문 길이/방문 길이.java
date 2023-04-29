import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int sy = 5;
        int sx = 5;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        Set<String> set = new HashSet<>();
        for(int i = 0; i < dirs.length(); i++) {
            char d = dirs.charAt(i);
            
            int j = 0;
            switch(d) {
                case 'R':
                    j = 1;
                    break;
                case 'D':
                    j = 2;
                    break;
                case 'L':
                    j = 3;
                    break;
            }
            
            int ny = sy + dy[j];
            int nx = sx + dx[j];
            
            if(ny < 0 || nx < 0 || ny > 10 || nx > 10) {
                continue;
            }
            
            StringBuilder sb = new StringBuilder();
            if(j == 0 || j == 3) {
                sb.append(ny);
                sb.append(nx);
                sb.append(sy);
                sb.append(sx);   
            } else {
                sb.append(sy);
                sb.append(sx);
                sb.append(ny);
                sb.append(nx);   
            }
            
            if(!set.contains(sb.toString())) {
                set.add(sb.toString());
                answer++;
            }
            
            sy = ny;
            sx = nx;
        }
        // System.out.println(set);
        return answer;
    }
}