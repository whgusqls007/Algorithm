import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] arr = new int[rows][columns];
        int index = 1;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                arr[i][j] = index++;
            }
        }
        
        // for(int j = 0; j < rows; j++) {
        //     System.out.println(Arrays.toString(arr[j]));
        // }
        // System.out.println();
        
        for(int i = 0; i < queries.length; i++) {
            int sy = queries[i][0] - 1;
            int sx = queries[i][1] - 1;
            int ey = queries[i][2] - 1;
            int ex = queries[i][3] - 1;
            
            int tmp = arr[sy][sx];
            int min = tmp;
            
            for(int j = 0; j < ey - sy; j++) {
                arr[sy + j][sx] = arr[sy + j + 1][sx];
                min = Math.min(arr[sy + j][sx], min);
            }
            
            for(int j = 0; j < ex - sx; j++) {
                arr[ey][sx + j] = arr[ey][sx + j + 1];
                min = Math.min(arr[ey][sx + j], min);
            }
            
            for(int j = 0; j < ey - sy; j++) {
                arr[ey - j][ex] = arr[ey - j - 1][ex];
                min = Math.min(arr[ey - j][ex], min);
            }
            
            for(int j = 0; j < ex - sx - 1; j++) {
                arr[sy][ex - j] = arr[sy][ex - j - 1];
                min = Math.min(arr[sy][ex - j], min);
            }
            
            arr[sy][sx + 1] = tmp;
            
            answer[i] = min;
            
            // for(int j = 0; j < rows; j++) {
            //     System.out.println(Arrays.toString(arr[j]));
            // }
            // System.out.println();
        }
        
        
        
        return answer;
    }
}