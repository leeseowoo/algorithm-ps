import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] isPrime = new boolean[n + 1];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = m; i <= n; i++) {
            if (isPrime[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
    }
}