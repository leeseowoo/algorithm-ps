class Solution {
    public int solution(int n) {
        int nextValue = n;
        int countCurrent = Integer.bitCount(n), countNext = 0;
        
        while(countCurrent != countNext) {
            nextValue += 1;
            countNext = Integer.bitCount(nextValue);
        }
        
        return nextValue;
    }
}