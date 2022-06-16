import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int length = clothes.length;
        Map<String, Integer> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
            set.add(clothes[i][1]);
        }
        
        for(String s : set) {
            answer = answer * (map.get(s) + 1);
        }
        
        return answer - 1;
    }
}