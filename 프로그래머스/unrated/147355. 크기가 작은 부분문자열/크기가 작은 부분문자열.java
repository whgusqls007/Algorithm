class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int size = p.length();
        long n = Long.parseLong(p);
        for(int i = size; i <= t.length(); i++){
            System.out.println(t.substring(i - size, i));
            if(Long.parseLong(t.substring(i - size, i)) <= n) {
                answer++;
            }
        }
        
        
        return answer;
    }
}