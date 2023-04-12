class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int[] totalSum = new int[sequence.length];
        
        totalSum[0] = sequence[0];
        for(int i = 1; i < sequence.length; i++) {
            totalSum[i] = totalSum[i-1] + sequence[i];
        }
        int minLength = Integer.MAX_VALUE;
        int start = Integer.MAX_VALUE;
        int end = Integer.MAX_VALUE;
        for(int i = 0; i < sequence.length; i++) {
            int lt = i;
            int rt = sequence.length - 1;
            
            while(lt <= rt) {
                int mid = (lt + rt) / 2;
                int sum = i != 0 ? totalSum[mid] - totalSum[i - 1] : totalSum[mid];
                
                if(sum == k) {
                    int length = mid - i;
                    if(length < minLength) {
                        start = i;
                        end = mid;
                        minLength = length;
                    }
                    break;
                } else if(sum < k) {
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }
        }
        answer[0] = start;
        answer[1] = end;
        return answer;
    }
}