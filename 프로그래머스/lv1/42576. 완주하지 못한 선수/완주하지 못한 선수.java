import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> completionHash = new HashMap<>();
        
        for(String name : completion) {
            completionHash.put(name, completionHash.getOrDefault(name, 0) + 1);
        }
        
        for(String name : participant) {
            int value = completionHash.getOrDefault(name, 0);
            
            if(value == 0) {
                answer = name;
                break;
                
            } else {
                completionHash.put(name, value - 1);
            }
        }
        
        return answer;
    }
}