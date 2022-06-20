import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0, length = numbers.length; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                answer.add(numbers[i] + numbers[j]);
            }
        }
        
        return answer.stream().distinct().sorted().mapToInt(Integer::intValue).toArray();
    }
}