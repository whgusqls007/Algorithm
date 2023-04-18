import java.util.*;

class Solution {
    int cnt = 0;
    public int solution(int[] nums) {
        int answer = -1;
        int[] arr = new int[3000];
        
        sifter(arr);

        dfs(nums, arr, 0, 0, 0);
        
        return cnt;
    }
    
    public void sifter(int[] arr) {
        for(int i = 2; i * i < 3000; i++) {
            for(int j = i * i; j < 3000; j += i) {
                arr[j] = -1;
            }
        }
    }
    
    public void dfs(int[] nums, int[] arr, int sum, int depth, int index) {
        for(int i = index; i < nums.length; i++) {
            if(depth == 2) {
                if(arr[sum + nums[i]] != -1) {
                    cnt++;
                    continue;
                }
            } else {
                dfs(nums, arr, sum + nums[i], depth + 1, i + 1);
            }
        }
    }
}