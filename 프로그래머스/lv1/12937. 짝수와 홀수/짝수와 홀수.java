class Solution {
    public String solution(int num) {
        String answer = "";
        if(num == 0) {
            return "Even";
        }
        if(num != 0 && (num & 1) == 1) {
            answer = "Odd";
        } else {
            answer = "Even";
        }
        return answer;
    }
}