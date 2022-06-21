import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> list = new ArrayList<>();
        int length = strings.length;
        String[] answer = new String[length];
        
        for(int i = 0; i < length; i++) {
            list.add(strings[i].charAt(n) + strings[i]);
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < length; i++) {
            answer[i] = list.get(i).substring(1);
        }
        
        return answer;
    }
}