import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int length = computers.length;
        visited = new boolean[length];
        
        for(int i = 0; i < length; i++) {
            if(!visited[i]) {
                bfs(i, computers, length);
                answer++;
            }
        }
        
        return answer;
    }
    
    void bfs(int startNode, int[][] computers, int length) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startNode);
        
        while(!q.isEmpty()) {
            int currentNode = q.poll();
            visited[currentNode] = true;
            
            for(int adj = 0; adj < length; adj++) {
                if(currentNode == adj) {
                    continue;
                }
                
                if(computers[currentNode][adj] == 1) {
                    if(!visited[adj]) {
                        q.offer(adj);
                    }
                }
            }
        }
    }
}