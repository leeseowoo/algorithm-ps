import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> q = new ArrayDeque<>();
        q.offerLast(arr[0]);
        
        for(int i = 1; i < arr.length; i++) {
            if(q.peekLast() != arr[i]) {
                q.offerLast(arr[i]);
            }
        }
        
        int[] answer = new int[q.size()];
        int idx = 0;
        
        while(!q.isEmpty()) {
            answer[idx++] = q.pollFirst();
        }
        
        return answer;
    }
}