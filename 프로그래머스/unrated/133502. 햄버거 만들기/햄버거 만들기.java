import java.util.*;

class Solution {
    public int solution(int[] ing) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int cnt = 0;
        for(int i = 0; i < ing.length; i++) {
            if(ing[i] == 1 && cnt != 3) {
                cnt = 1;
            } else if(cnt == 1 && ing[i] == 2 && !stack.isEmpty() && stack.peek() == 1) {
                cnt = 2;
            } else if(cnt == 2 && ing[i] == 3 && !stack.isEmpty() && stack.peek() == 2) {
                cnt = 3;
            } else if (cnt == 3 && ing[i] == 1 && !stack.isEmpty() && stack.peek() == 3) {
                cnt = 4;
            } else {
                cnt = 0;
            }
            
            stack.push(ing[i]);
            
            if(cnt == 4) {
                answer++;
                
                while(!stack.isEmpty() && cnt > 0) {
                    cnt--;
                    stack.pop();
                }
                
                while(!stack.isEmpty() && cnt < 3) {
                    stack2.push(stack.pop());
                    cnt++;
                }
                cnt = 0;
                while(!stack2.isEmpty()) {
                    int n = stack2.pop();
                    if(n == 1 && cnt != 3) {
                        cnt = 1;
                    } else if(cnt == 1 && n == 2 && !stack.isEmpty() && stack.peek() == 1) {
                        cnt = 2;
                    } else if(cnt == 2 && n == 3 && !stack.isEmpty() && stack.peek() == 2) {
                        cnt = 3;
                    } else if (cnt == 3 && n == 1 && !stack.isEmpty() && stack.peek() == 3) {
                        cnt = 4;
                    } else {
                        cnt = 0;
                    }
                    stack.push(n);
                }
            }
            
            // System.out.println(stack + " " + cnt);
        }
        
        return answer;
    }
}