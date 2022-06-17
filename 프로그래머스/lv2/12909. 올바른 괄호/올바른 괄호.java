import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> open = new ArrayDeque<>();
        
        for(char c : s.toCharArray()) {
            if(c == '(') {
                open.offerLast('(');
            } else {
                if(open.isEmpty()) {
                    answer = false;
                    break;
                } else {
                    open.pollLast();
                }
            }
        }
        
        if(!open.isEmpty()) {
            answer = false;
        }

        return answer;
    }
}