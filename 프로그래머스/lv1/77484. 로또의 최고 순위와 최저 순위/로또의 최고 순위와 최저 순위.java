import java.util.HashSet;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashSet<Integer> set = new HashSet<>();
        int count = 0, zeroCount = 0;
        
        for(int num : win_nums) {
            set.add(num);    
        }
        
        for(int myNum : lottos) {
            if(myNum == 0) {
                zeroCount += 1;
            } else if(set.contains(myNum)) {
                count += 1;
            }
        }
        
        int[] counts = new int[2];
        counts[0] = count + zeroCount;
        counts[1] = count;
        
        for(int i = 0; i <= 1; i++) {
            switch(counts[i]) {
                case 6:
                    answer[i] = 1;
                    break;
                case 5:
                    answer[i] = 2;
                    break;
                case 4:
                    answer[i] = 3;
                    break;
                case 3:
                    answer[i] = 4;
                    break;
                case 2:
                    answer[i] = 5;
                    break;
                default:
                    answer[i] = 6;
            }
        }
        
        return answer;
    }
}