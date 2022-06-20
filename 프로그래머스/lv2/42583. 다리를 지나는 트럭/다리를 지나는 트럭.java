import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int ptr = 0;
        int length = truck_weights.length;
        int bridgeWeight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        while(ptr < length) {
            if(bridge.size() == bridge_length) {
                bridgeWeight -= bridge.poll();
            }
            
            if(weight - bridgeWeight >= truck_weights[ptr]) {
                bridgeWeight += truck_weights[ptr];
                bridge.offer(truck_weights[ptr++]);
            } else {
                bridge.offer(0);
            }
            
            answer++;
        }
        
        return answer + bridge_length;
    }
}