class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        int length = s.length();
        
        if(length == 4 || length == 6) {
            answer = isDigit(s);
        }
        
        return answer;
    }
    
    public boolean isDigit(String s) {
        for(char c : s.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        
        return true;
    }
}