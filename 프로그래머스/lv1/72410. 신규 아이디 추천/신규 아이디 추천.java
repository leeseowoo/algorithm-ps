class Solution {
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int lng = new_id.length();
        
        // 1, 2
        for(int i = 0; i < lng; i++) {
            char curr = Character.toLowerCase(new_id.charAt(i));
            if(Character.isLetterOrDigit(curr) || curr == '-' || curr == '_' || curr == '.') {
                sb.append(curr);
            }
        }
        
        String[] splitId = String.valueOf(sb).split("\\.");
        sb = new StringBuilder();
        lng = splitId.length;
        
        // 3, 4
        for(int i = 0; i < lng; i++) {
            if(splitId[i].length() != 0) {
                sb.append(splitId[i] + ".");
            }
        }
        
        if(sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        } else {
            // 5
            sb.append("a");
        }
        
        // 6
        if(sb.length() >= 16) {
            answer = sb.substring(0, 15);
            if(answer.endsWith(".")) {
                answer = answer.substring(0, answer.length() - 1);
            }
            
        } else if(sb.length() <= 2) {
            // 7
            for(int i = sb.length(); i < 3; i++) {
                sb.append(sb.charAt(sb.length() - 1));
            }
            answer = String.valueOf(sb);
            
        } else {
            answer = String.valueOf(sb);
        }
        
        return answer;
    }
}