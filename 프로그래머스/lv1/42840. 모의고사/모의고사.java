import java.util.Arrays;

class Solution {
    public int[] solution(int[] answers) {
        int[] scores = new int[3];
        int[] way1 = new int[]{1, 2, 3, 4, 5};
        int[] way2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] way3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int p1 = 0, p2 = 0, p3 = 0;
        
        for(int ans : answers) {
            if(p1 == way1.length) p1 = 0;
            if(p2 == way2.length) p2 = 0;
            if(p3 == way3.length) p3 = 0;
            
            if(way1[p1] == ans) scores[0]++;
            if(way2[p2] == ans) scores[1]++;
            if(way3[p3] == ans) scores[2]++;
            
            p1++;
            p2++;
            p3++;
        }
        
        int max = Arrays.stream(scores).max().getAsInt();
        int num = 0;
        for(int i=0; i<3; i++) {
            if(max == scores[i]) {
                num++;
            }
        }
        
        int[] result = new int[num];
        int idx = 0;
        for(int i=0; i<3; i++) {
            if(max == scores[i]) {
                result[idx++] = i+1;
            }
        }
        
        return result;
    }
}