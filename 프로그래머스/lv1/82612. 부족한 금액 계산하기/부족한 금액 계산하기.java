class Solution {
    public long solution(int price, int money, int count) {
        long answer = money;
        int cnt = 1;
        while(cnt <= count) {
            answer -= price * cnt++;
        }
        if(answer >= 0) {
            return 0;
        }
        return -answer;
    }
}