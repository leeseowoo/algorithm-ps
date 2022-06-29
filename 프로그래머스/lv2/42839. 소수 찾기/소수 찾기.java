import java.util.Set;
import java.util.HashSet;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    boolean[] check;
    
    public int solution(String numbers) {
        int lng = numbers.length();
        check = new boolean[lng];
        StringBuilder sb = new StringBuilder();
        
        calculate(numbers, lng, 0, sb);
        
        return set.size();
    }
    
    public void calculate(String numbers, int lng, int depth, StringBuilder sb) {
        if(depth == lng) {
            return;
        }
        
        for(int i = 0; i < lng; i++) {
            if(!check[i]) {
                check[i] = true;
                sb.append(numbers.charAt(i));
                
                int n = Integer.parseInt(String.valueOf(sb));
                double sqrt = Math.sqrt(n);
                boolean flag = true;
                
                for(int j = 2; j <= sqrt; j++) {
                    if(n % j == 0) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {
                    if(n != 0 && n != 1) {
                        set.add(n);
                    }
                }
                
                calculate(numbers, lng, depth + 1, sb);
                check[i] = false;
                sb.delete(depth, depth + 1);
            }
        }
    }
}