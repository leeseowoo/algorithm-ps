class Solution {
    
    static int answer, length;
    static int[] numsClone;
    static int[] values = new int[3];
    
    public int solution(int[] nums) {
        length = nums.length;
        numsClone = nums.clone();

        makeCombination(0, 0);
        
        return answer;
    }
    
    public void makeCombination(int depth, int start) {
        if(depth == 3) {
            int value = values[0] + values[1] + values[2];
            if(isPrime(value)) {
                answer++;
            }
            return;
        }
        
        for(int i = start; i < length; i++) { 
            values[depth] = numsClone[i];
            makeCombination(depth + 1, i + 1);
        }
    }
    
    public boolean isPrime(int value) {
        double sqrt = Math.sqrt(value);
        for(int i = 2; i <= sqrt; i++) {
            if(value % i == 0) {
                return false;
            }
        }
        return true;
    }
}