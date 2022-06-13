class Solution {
    public String solution(int n) {
        String answer = "수박".repeat(n/2);
        
        if(n % 2 != 0) {
            answer = answer + "수";
        }
        
        return answer;
    }
}