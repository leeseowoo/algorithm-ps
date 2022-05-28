import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = wines[1];

        if (n != 1) {
            dp[2] = wines[1] + wines[2];

            for (int i = 3; i <= n; i++) {
                int first = wines[i] + wines[i-1] + dp[i-3];
                int second = wines[i] + dp[i-2];
                int third = dp[i - 1];
                dp[i] = Math.max(Math.max(first, second), third);
            }
        }

        bw.write(dp[n] + "");
        bw.flush();
    }
}