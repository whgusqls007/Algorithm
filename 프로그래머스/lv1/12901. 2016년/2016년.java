class Solution {
    public String solution(int a, int b) {
        String[] date = {"THU","FRI","SAT","SUN","MON","TUE","WED",};
        String answer = "";
        int[] month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int sum = 0;
        for(int i = 1; i < a; i++) {
            sum += month[i];
        }
        sum += b;
        
        answer = date[sum % 7];
        
        return answer;
    }
}