import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

class Solution {
    
    static int leftX = 3, leftY = 0;
    static int rightX = 3, rightY = 2;
    static HashMap<Integer, int[]> keypad = new HashMap<>();
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] commands = new int[]{0, 1, 0, 2, 1, 0, 2, 1, 0, 2};   // 0:BFS, 1:L, 2:R
        int key = 1;
        
        for(int i = 0; i <= 2; i++) {
            for(int j = 0; j <= 2; j++) {
                keypad.put(key++, new int[]{i, j});
            }
        }
        keypad.put(0, new int[]{3, 1});
        
        for(int number : numbers) {
            if(commands[number] == 0) {
                int leftResult = bfs(number, 1);
                int rightResult = bfs(number, 2);
                
                if(leftResult < rightResult) {
                    answer.append("L");
                    move(number, 1);
                } else if(rightResult < leftResult) {
                    answer.append("R");
                    move(number, 2);
                } else {
                    if(hand.equals("left")) {
                        answer.append("L");
                        move(number, 1);
                    } else {
                        answer.append("R");
                        move(number, 2);
                    }
                }
                
            } else if(commands[number] == 1) {
                answer.append("L");
                move(number, 1);
                
            } else if(commands[number] == 2) {
                answer.append("R");
                move(number, 2);
            }
        }
        
        return String.valueOf(answer);
    }
    
    public int bfs(int target, int which) {
        int startX, startY;
        int[] targetPosition = keypad.get(target);
        int[][] distance = new int[4][3];
        Queue<int[]> q = new LinkedList<>();
        if(which == 1) {
            startX = leftX;
            startY = leftY;
        } else {
            startX = rightX;
            startY = rightY;
        }
        q.offer(new int[]{startX, startY});
        distance[startX][startY] = 1;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int currentX = current[0];
            int currentY = current[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];
                
                if(nx < 0 || nx > 3 || ny < 0 || ny > 2) {
                    continue;
                }
                
                if(distance[nx][ny] == 0) {
                    distance[nx][ny] = distance[currentX][currentY] + 1;
                    if(targetPosition[0] == nx && targetPosition[1] == ny) {
                        return distance[nx][ny] - 1;
                    }
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        
        return -1;
    }
    
    public void move(int key, int which) {
        int[] position = keypad.get(key);
        if(which == 1) {
            leftX = position[0];
            leftY = position[1];
        } else {
            rightX = position[0];
            rightY = position[1];
        }
    }
}