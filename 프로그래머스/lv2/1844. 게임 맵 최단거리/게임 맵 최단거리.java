import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int n = maps.length - 1;
        int m = maps[0].length - 1;
        Queue<int[]> location = new LinkedList<>();
        
        location.offer(new int[]{0, 0});
        maps[0][0] = 2;
        
        while(!location.isEmpty()) {
            int[] current = location.poll();
            int x = current[0];
            int y = current[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx > n || ny > m) {
                    continue;
                }
                
                if(maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    location.offer(new int[]{nx, ny});
                }
            }
        }
        
        if(maps[n][m] == 1) {
            answer = -1;
        } else {
            answer = maps[n][m] - 1;
        }
        
        return answer;
    }
}