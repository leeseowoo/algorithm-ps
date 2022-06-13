class Solution {
    public String solution(String s) {
        String answer = "";
        int length = s.length();
        
        answer = s.substring((length-1)/2, (length/2)+1);
        
        return answer;
    }
}