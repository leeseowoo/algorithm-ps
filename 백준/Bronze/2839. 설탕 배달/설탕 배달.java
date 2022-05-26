import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sugar = Integer.parseInt(br.readLine());
        int[] dp = new int[sugar + 10];
        int bags = 0;

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 6; i <= sugar; i++) {
            bags = Math.min(dp[i-3], dp[i-5]) + 1;
            if (bags < 0) {
                continue;
            }
            dp[i] = bags;
        }

        if (dp[sugar] == Integer.MAX_VALUE) {
            bw.write(-1 + "");
        } else {
            bw.write(dp[sugar] + "");
        }
        bw.flush();
    }
}