import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int index = -1;
        int[] counter = new int[11];
        Queue<Integer> printer = new LinkedList<>();
        int length = priorities.length;
        
        for(int i = 0; i < length; i++) {
            printer.offer(i);
            counter[priorities[i]]++;
        }
        
        while(location != index) {
            index = printer.poll();
            boolean flag = false;
            for(int i = priorities[index] + 1; i <= 10; i++) {
                if(counter[i] > 0) {
                    flag = true;
                    break;
                }
            }
            
            if(flag) {
                printer.offer(index);
                index = -1;
            } else {
                counter[priorities[index]]--;
                answer++;
            }
        }
        
        return answer;
    }
}