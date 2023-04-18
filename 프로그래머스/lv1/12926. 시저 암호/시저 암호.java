class Solution {
    public String solution(String s, int n) {
        String answer = "";
        // System.out.println((char) 122);
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer += ' ';
                continue;
            }
            char word = (char) (s.charAt(i) + n);
            if(65 <= (int) s.charAt(i) && (int) s.charAt(i) <= 90) {
                if((int) word > 90) {
                    word = (char) (65 + ((int) word - 91));
                }
            } else {
                if((int) word > 122) {
                    word = (char) (97 + ((int) word - 123));
                }
            }
            answer += word;
        }
        return answer;
    }
}