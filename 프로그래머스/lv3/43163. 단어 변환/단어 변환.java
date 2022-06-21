class Solution {
    
    static int globalCount = Integer.MAX_VALUE;
    static int length;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        length = words.length;
        visited = new boolean[length];
        
        dfs(begin, target, 0, words);
        
        if(globalCount == Integer.MAX_VALUE) {
            globalCount = 0;
        }
        
        return globalCount;
    }
    
    static void dfs(String str, String target, int localCount, String[] words) {
        if(str.equals(target)) {
            if(localCount < globalCount) {
                globalCount = localCount;
            }
            return;
        }
        
        for(int i = 0; i < length; i++) {
            if(!visited[i]) {
                if(check(str, words[i])) {
                    visited[i] = true;
                    dfs(words[i], target, localCount + 1, words);
                    visited[i] = false;
                }
            }
        }
    }
    
    static boolean check(String str1, String str2) {
        int count = 0;
        int length = str1.length();
        
        for(int i = 0; i < length; i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count++;
            }
        }
        
        if(count == 1) {
            return true;
        } else {
            return false;
        }
    }
}