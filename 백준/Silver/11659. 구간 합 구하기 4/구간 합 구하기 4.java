import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());   // 수의 개수
        int m = Integer.parseInt(st.nextToken());   // 합을 구해야 하는 횟수

        int[] nums = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] newNums = new int[n + 1];
        int sum = 0;

        for(int i = 1; i <= n; i++) {
            newNums[i] = sum += nums[i];
        }

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            bw.write(newNums[j] - newNums[i - 1] + "\n");
        }

        bw.flush();
    }
}