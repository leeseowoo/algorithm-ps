import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int lng = number.length();
        Deque<Character> stk = new ArrayDeque();
        stk.offerLast(number.charAt(0));
        
        for(int i = 1; i < lng; i++) {
            while(!stk.isEmpty() && stk.peekLast() < number.charAt(i) && k > 0) {
                stk.pollLast();
                k--;
            }
            
            stk.offerLast(number.charAt(i));
        }
        
        while(k-- > 0) {
            stk.pollLast();
        }
        
        while(!stk.isEmpty()) {
            sb.append(stk.pollFirst());
        }
        
        return String.valueOf(sb);
    }
}