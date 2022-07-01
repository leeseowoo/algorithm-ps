import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int lng = arr.length;
        int[] nums = new int[lng];
        
        for(int i = 0; i < lng; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(nums);
        answer += nums[0] + " " + nums[lng - 1];
        
        return answer;
    }
}