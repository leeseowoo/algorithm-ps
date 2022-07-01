import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int lng = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i = 0; i < lng; i++) {
            answer += A[i] * B[lng - 1 - i];
        }

        return answer;
    }
}