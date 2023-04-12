class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = sequence[0];
        int minLength = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (end < sequence.length) {
            if (sum == k) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    result[0] = start;
                    result[1] = end;
                }
                sum -= sequence[start];
                start++;
            } else if (sum < k) {
                end++;
                if (end < sequence.length) {
                    sum += sequence[end];
                }
            } else {
                sum -= sequence[start];
                start++;
            }
        }

        return result;
    }
}