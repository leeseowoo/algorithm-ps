class Solution {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        
        for(int i = 0; i < length; i++) {
            int count = 0;
            for(int j = i + 1; j < length; j++) {
                if(prices[i] <= prices[j]) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }
            answer[i] = count;
        }
        
        return answer;
    }
}