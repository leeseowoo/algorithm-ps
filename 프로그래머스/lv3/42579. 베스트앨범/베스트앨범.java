import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

class Solution {
    public Object[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();
        Map<String, ArrayList<Integer>> set = new HashMap<>();
        int lng = plays.length;
        
        for(int i = 0; i < lng; i++) {
            counts.put(genres[i], counts.getOrDefault(genres[i], 0) + plays[i]);
            ArrayList<Integer> list = set.getOrDefault(genres[i], new ArrayList<>());
            list.add(i);
            set.put(genres[i], list);
        }
        
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(counts.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
                
        for(Map.Entry<String, Integer> ent : entries) {
            ArrayList<Integer> list = set.get(ent.getKey());
            int size = list.size();
            int cnt = 2;
            
            while(cnt-- > 0 && size-- > 0) {
                int max = Integer.MIN_VALUE;
                int idx = -1;
                
                for(int i : list) {
                    if(plays[i] > max) {
                        max = plays[i];
                        idx = i;
                    }
                }
                
                answer.add(idx);
                plays[idx] = -1;
            }
            
        }
        
        return answer.toArray();
    }
}