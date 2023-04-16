class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int prevStar = 1;
        for(int i = dartResult.length() - 1; i > -1; i--) {
            int bonus = 1;
            if(dartResult.charAt(i) == '#') {
                bonus = -1;
                i--;
            } else if(dartResult.charAt(i) == '*') {
                bonus = 2;
                i--;
            }
            int option = dartResult.charAt(i) == 'T' ? 3 : dartResult.charAt(i) == 'D' ? 2 : 1;
            i--;
            int score = (int) (dartResult.charAt(i) - '0');
            if(score == 0) {
                if(i != 0 && dartResult.charAt(i - 1) == '1') {
                    score = 10;
                    i--;
                }
            }
            
            answer += Math.pow(score, option) * (bonus) * prevStar;
            if(bonus == 2) {
                prevStar = 2;
            } else {
                prevStar = 1;
            }
        }
        
        return answer;
    }
}