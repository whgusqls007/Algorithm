class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String[] nums = Integer.toString(n, k).replaceAll("0+", "0").split("0");

        continuePoint: for (int i = 0; i < nums.length; i++) {
            long num = Long.parseLong(nums[i]);
            if(num < 2) {
                continue;
            }
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    continue continuePoint;
                }
            }
            answer++;
        }

        return answer;
    }
}