class Solution {
    public boolean solution(int x) {
        boolean answer = false;
        int sum = 0;
        int dividend = x, quotient, remainder;
        
        while(dividend > 0) {
            quotient = dividend / 10;
            remainder = dividend % 10;
            sum += remainder;
            dividend = quotient;
        }

        if(x % sum == 0) {
            answer = true;
        }
        
        return answer;
    }
}