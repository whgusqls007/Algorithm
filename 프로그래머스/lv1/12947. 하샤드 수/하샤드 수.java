class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String s = String.valueOf(x);
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            sum += (int) s.charAt(i) - '0';
        }
        if(x % sum != 0) {
            answer = false;
        }
        return answer;
    }
}