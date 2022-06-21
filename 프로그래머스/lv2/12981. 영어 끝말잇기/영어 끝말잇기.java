import java.util.Set;
import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        return start(n, words);
    }
    
    int[] start(int n, String[] words) {
        int[] counts = new int[n + 1];
        Set<String> set = new HashSet<>();
        int person = 1;
        String previous = String.valueOf(words[0].charAt(0));
        
        int length = words.length;
        
        for(int i = 0; i < length; i++) {
            counts[person]++;
            
            if(words[i].length() == 1) {
                return new int[]{person, counts[person]};
            }
            
            if(set.contains(words[i])) {
                return new int[]{person, counts[person]};
            }
            
            if(previous.charAt(previous.length() - 1) != words[i].charAt(0)) {
                return new int[]{person, counts[person]};
            }
            
            previous = words[i];
            set.add(previous);
            if(++person > n) {
                person = 1;
            }
        }
        
        return new int[]{0, 0};
    }
}