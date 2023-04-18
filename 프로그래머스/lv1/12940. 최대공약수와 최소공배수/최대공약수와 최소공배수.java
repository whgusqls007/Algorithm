class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        if(n > m) {
            int tmp = n;
            n = m;
            m = tmp;
        }
        
        answer[0] = GCD(m, n); 
        
        answer[1] = n * m / answer[0];
        
        return answer;
    }
    
    public int GCD(int a, int b) {
        int d = a % b;
        if(d == 0) {
            return b;
        } else {
            return GCD(b, d);
        }
    }
}