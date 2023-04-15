class Solution {
    int answer = 0;
    public int solution(int[] number) {
        dfs(number, 0, 0, 0);
        return answer;
    }
    
    public void dfs(int[] number, int index, int depth, int sum) {
        if(depth == 3) {
            if(sum == 0) {
                answer++;
            }
        }
        for(int i = index; i < number.length; i++) {
            dfs(number, i + 1, depth + 1, sum + number[i]);
        }
    }
}