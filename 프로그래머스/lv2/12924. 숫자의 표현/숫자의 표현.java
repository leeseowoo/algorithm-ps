class Solution {
    public int solution(int n) {
        int answer = 0, start = 1, end = 1, sum = 0, stop = n / 2 + 1;

        while(start < stop) {
            if(sum < n) {
                sum += end;
                end++;
            } else if(sum >= n) {
                if(sum == n) {
                    answer++;
                }
                sum -= start;
                start++;
            }
        }
        return answer + 1;
    }
}