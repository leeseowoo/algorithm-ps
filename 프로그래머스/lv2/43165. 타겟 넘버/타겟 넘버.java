class Solution {
    
    static int answer;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers.length, numbers, target, 0);
        
        return answer;
    }
    
    static void dfs(int index, int depth, int length, int[] numbers, int target, int sum) {
        if (depth == length) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        
        dfs(index + 1, depth + 1, length, numbers, target, sum + numbers[index]);
        dfs(index + 1, depth + 1, length, numbers, target, sum - numbers[index]);
    }
}