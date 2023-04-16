import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                if(!set.contains(numbers[i] + numbers[j])) {
                    set.add(numbers[i] + numbers[j]);
                    list.add(numbers[i] + numbers[j]);
                }    
            }
        }
        
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}