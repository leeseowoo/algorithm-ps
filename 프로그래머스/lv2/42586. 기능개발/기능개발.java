import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int length = progresses.length;
        
        for(int i = 0; i < length; i++) {
            int days = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) {
                days += 1;
            }
            
            if(!queue.isEmpty() && queue.peek() < days) {
                list.add(queue.size());
                queue.clear();
            }
                
            queue.offer(days);
        }
        
        list.add(queue.size());
        
        int size = list.size();
        int[] answer = new int[size];
        
        for(int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}