import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        people = sorting(people);
        
        System.out.println(Arrays.toString(people));
        int lt = 0;
        int rt = people.length - 1;
        
        while(lt <= rt) {
            if(lt == rt) {
                answer++;
                break;
            }
            int sum = people[lt] + people[rt];
            if(sum > limit) {
                answer++;
                rt--;
            } else {
                answer++;
                lt++;
                rt--;
            }
        }
        
        return answer;
    }
    
    public int[] sorting(int[] people) {
        int[] count = new int[241];
        int[] result = new int[people.length];
        
        for(int i = 0; i < people.length; i++) {
            count[people[i]]++;
        }
        
        for(int i = 1; i < 241; i++) {
            count[i] += count[i - 1];
        }
        
        for(int i = 0; i < people.length; i++) {
            result[--count[people[i]]] = people[i];
        }
        
        return result;
    }
}