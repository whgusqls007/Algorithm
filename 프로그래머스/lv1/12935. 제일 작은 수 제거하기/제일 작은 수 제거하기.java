import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        if(arr.length == 1) {
            return new int[] {-1};
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            list.add(new int[] {arr[i], i});
        }
        
        Collections.sort(list, (e1, e2) -> e1[0] - e2[0]);
        
        answer = new int[list.size() - 1];
        int index = list.get(0)[1];
        for(int i = 0; i < list.size(); i++) {
            int[] num = list.get(i);
            if(index == num[1]) {
                continue;
            } else if(index < num[1]) {
                answer[num[1] - 1] = num[0];
            } else {
                answer[num[1]] = num[0];
            }
        }
        
        return answer;
    }
}