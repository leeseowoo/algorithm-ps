import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {        
        return getResult(phone_book);
    }
    
    public boolean getResult(String[] phoneBook) {
        int length = phoneBook.length;
        
        Arrays.sort(phoneBook);

        for(int i = 0; i < length - 1; i++) {
            if(phoneBook[i + 1].startsWith(phoneBook[i])) {
                return false;
            }
        }
        
        return true;
    }
}