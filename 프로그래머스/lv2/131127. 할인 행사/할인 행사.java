import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            map.put(want[i], i);
        }
        
        int[] ch = new int[number.length];
        
        for(int i = 0; i < 10; i++) {
            int index = map.getOrDefault(discount[i], -1);
            if(index != -1) {
                ch[index]++;
            }
        }
        
        if(check(ch, number)) {
            answer++;
        }
        
        int lt = 1;
        int rt = 10;
        
        while(rt < discount.length) {
            int index = map.getOrDefault(discount[lt - 1], -1);
            if(index != -1) {
                ch[index]--;
            }
            
            index = map.getOrDefault(discount[rt], -1);
            if(index != -1) {
                ch[index]++;
            }
            
            
            if(check(number, ch)) {
                answer++;
            }
            
            lt++;
            rt++;
        }
        
        return answer;
    }
    
    public boolean check(int[] arr1, int[] arr2) {
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}