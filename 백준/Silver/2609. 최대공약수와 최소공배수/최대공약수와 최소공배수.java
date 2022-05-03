import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int gcd = getGcd(m, n);
        int lcm = m * n / gcd;

        bw.write(gcd + "\n" + lcm);
        bw.flush();
    }

    public static int getGcd(int m, int n) {
        if (n == 0) {
            return m;
        }
        return getGcd(n, m % n);
    }
}