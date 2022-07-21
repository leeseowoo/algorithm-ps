import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int pickCnt = nums.length / 2;
        
        for(int num : nums) {
            set.add(num);
        }
        
        
        if(set.size() >= pickCnt) {
            answer = pickCnt;
        } else {
            answer = set.size();
        }
        
        return answer;
    }
}