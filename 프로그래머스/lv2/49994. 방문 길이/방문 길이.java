import java.util.Set;
import java.util.HashSet;

class Solution {
    
    int x, y;
    Set<String> set = new HashSet<>();
    
    public int solution(String dirs) {
        int length = dirs.length();
        
        for(int i = 0; i < length; i++) {
            move(dirs.charAt(i));
        }
        
        return set.size() / 2;
    }
    
    void move(char command) {
        int nx = 0, ny = 0;
        
        switch(command) {
            case 'U':
                nx = x;
                ny = y + 1;
                break;
            case 'D':
                nx = x;
                ny = y - 1;
                break;
            case 'L':
                nx = x - 1;
                ny = y;
                break;
            case 'R':
                nx = x + 1;
                ny = y;
        }
        
        if(nx < -5 || nx > 5 || ny < -5 || ny > 5) {
            return;
        }
        
        set.add("" + x + y + nx + ny);
        set.add("" + nx + ny + x + y);
        x = nx;
        y = ny;
    }
}