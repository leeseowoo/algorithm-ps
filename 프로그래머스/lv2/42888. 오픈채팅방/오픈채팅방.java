import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class Solution {
    
    Map<String, String> nicknameMap = new HashMap<>();
    List<String> result = new ArrayList<>();
    
    public String[] solution(String[] record) {
        setNickname(record);
        getResult(record);
        
        return result.toArray(new String[0]);
    }
    
    public void setNickname(String[] record) {
        for(String i : record) {
            String[] data = i.split(" ");
            
            if(data[0].equals("Enter") || data[0].equals("Change")) {
                nicknameMap.put(data[1], data[2]);
            }
        }
    }
    
    public void getResult(String[] record) {
        
        for(String i : record) {
            String[] data = i.split(" ");
            String nickname = nicknameMap.get(data[1]);
            
            if(data[0].equals("Enter")) {
                result.add(nickname + "님이 들어왔습니다.");
                
            } else if(data[0].equals("Leave")) {
                result.add(nickname + "님이 나갔습니다.");
            }
        }
    }
}