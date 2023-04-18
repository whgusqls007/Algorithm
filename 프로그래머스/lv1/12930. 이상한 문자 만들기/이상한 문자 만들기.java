class Solution {
    public String solution(String s) {
        String answer = "";
        String str = s.toUpperCase();
        int index = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                answer += ' ';
                index = 0;
            } else if((index & 1) == 1) {
                answer += Character.toLowerCase(str.charAt(i));
                index++;
            } else {
                answer += str.charAt(i);
                index++;
            }
        }
        
        return answer;
    }
}