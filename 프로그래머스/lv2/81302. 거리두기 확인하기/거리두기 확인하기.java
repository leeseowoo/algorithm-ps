class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {1, 1, 1, 1, 1};
        
        for(int i = 0; i < 5; i++) {                    // 대기실
            room:
            for(int j = 0; j < 5; j++) {                // 행
                for(int k = 0; k < 5; k++) {            // 열
                    if(places[i][j].charAt(k) == 'P') {         // 상하좌우에 P가 1개라도 있으면 안 된다
                        if(!check(places[i], j, k, 1)) {
                            answer[i] = 0;
                            break room;
                        }
                    } else if(places[i][j].charAt(k) == 'O') {  // 상하좌우에 P가 2개 이상 있으면 안 된다
                        if(!check(places[i], j, k, 2)) {
                            answer[i] = 0;
                            break room;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    public boolean check(String[] room, int x, int y, int type) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int count = 0;
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || ny < 0 || nx > 4 || ny > 4) {
                continue;
            }
            
            if(room[nx].charAt(ny) == 'P') {
                count++;
            }
        }
        
        if(type == 1 && count >= 1) {
            return false;
        } else if(type == 2 && count >= 2) {
            return false;
        } else {
            return true;
        }
    }
}