class Solution {
    int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        dfs(arr, 0, 0, arr.length);
        
        return answer;
    }
    
    public void dfs(int[][] arr, int y, int x, int n) {
        boolean flag = false;
        int num = arr[y][x];
        
        if(n == 1) {
            if(num == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
            return;
        }
        
        breakPoint : for(int i = y; i < y + n; i++) {
            for(int j = x; j < x + n; j++) {
                if(num != arr[i][j]) {
                    flag = true;
                    break breakPoint;
                }
            }
        }
        
        if(flag) {
            dfs(arr, y, x, n / 2);
            dfs(arr, y, x + n / 2, n / 2);
            dfs(arr, y + n / 2, x, n / 2);
            dfs(arr, y + n / 2, x + n / 2, n / 2);
        } else {
            if(num == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
        }
    }
}