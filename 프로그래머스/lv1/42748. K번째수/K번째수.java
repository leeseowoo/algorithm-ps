import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] clone = new int[array.length];
        int[] result = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            System.arraycopy(array, 0, clone, 0, array.length);
            Arrays.sort(clone, commands[i][0]-1, commands[i][1]);
            result[i] = clone[commands[i][0]+commands[i][2]-2];
        }
        
        return result;
    }
}