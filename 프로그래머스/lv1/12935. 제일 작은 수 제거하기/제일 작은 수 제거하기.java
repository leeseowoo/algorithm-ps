import java.util.Arrays;
import java.util.OptionalInt;

class Solution {
    public int[] solution(int[] arr) {

        OptionalInt min = Arrays.stream(arr).min();

        arr = Arrays.stream(arr).filter(n -> n != min.getAsInt()).toArray();

        if (arr.length == 0) {
            return new int[]{-1};
        }
        
        return arr;
    }
}