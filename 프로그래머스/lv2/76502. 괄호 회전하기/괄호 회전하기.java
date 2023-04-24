import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        ArrayDeque<Character> dq = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            dq.offerLast(s.charAt(i));
        }
        
        if(check(dq)) {
            answer++;
        }
        
        for(int i = 0; i < s.length() - 1; i++) {
            dq.offerLast(dq.pollFirst());
            if(check(dq)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean check(ArrayDeque<Character> dq) {
        Stack<Character> stack = new Stack<>();
        
        Iterator<Character> it = dq.iterator();
        
        while(it.hasNext()) {
            char c = it.next();
            if(c == '}') {
                if(!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else if(c == ')') {
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else if(c == ']') {
                if(!stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        } 
        return false;
    }
}