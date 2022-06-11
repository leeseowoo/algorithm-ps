import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int lostLen = lost.length, reserveLen = reserve.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        int answer = lostLen + reserveLen;
        int start = 0;
        
        for(int i = 0; i < lostLen; i++) {
            for(int j = start; j < reserveLen; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    start = j + 1;
                    answer -= 1;
                    break;
                }
            }
        }
        
        int lent = 0;
        start = 0;
        
        for(int i = 0; i < lostLen; i++) {
            if(lost[i] == -1) {
                continue;
            }
            
            for(int j = start; j < reserveLen; j++) {
                if(reserve[j] == -1) {
                    continue;
                }
                
                if(Math.abs(lost[i] - reserve[j]) == 1) {
                    lent++;
                    start = j + 1;
                    break;
                }
            }
        }
        
        answer = (n - answer) + reserveLen + lent;
        return answer;
    }
}