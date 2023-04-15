class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a) {
            int c = n / a;
            int d = c * a; // 마신 콜라
            int e = c * b; // 다시 받을 수 있는 콜라
            n -= d;
            n += e;
            answer += e;
        }
        return answer;
    }
}