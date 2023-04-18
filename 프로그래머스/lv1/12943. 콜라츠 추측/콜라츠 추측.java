class Solution {
    public int solution(int num) {
        int answer = 0;
        int cnt = 0;
        long n = (long) num;
        while(cnt < 500) {
            if(n == 1) {
                break;
            }
            
            if((n & 1) == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
            cnt++;
            
        }
        
        if(cnt == 500) {
            answer = -1;
        } else {
            answer = cnt;
        }
        return answer;
    }
}