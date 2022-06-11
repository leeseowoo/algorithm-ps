import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> basket = new ArrayDeque<>();
        int row = board.length;
        int column = board[0].length;
        int[] ptr = new int[column];
        
        for(int i = 0; i < column; i++) {
            for(int j = 0; j < row; j++) {
                if(board[j][i] != 0) {
                    ptr[i] = j;
                    break;
                }
            }
        }
        
        for(int move : moves) {
            int doll = board[ptr[move - 1]][move - 1];
            
            if(doll == 0) {
                continue;
            }
            
            board[ptr[move - 1]][move - 1] = 0;
            
            if(ptr[move - 1] < row - 1) {
                ptr[move - 1] += 1;
            }
            
            if(!basket.isEmpty()) {
                if(basket.peekLast() == doll) {
                    answer += 2;
                    basket.pollLast();
                    continue;
                }
            } 
            
            basket.offerLast(doll);
        }
    
        return answer;
    }
}