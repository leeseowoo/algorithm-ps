import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        int p1 = 0, p2 = 0;
        int sum = 0;
        int count = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        while (p1 < n) {
            if (sum > m || p2 == n) {
                sum = sum - numbers[p1++];

            } else {
                sum = sum + numbers[p2++];
            }

            if (sum == m) {
                count += 1;
            }
        }

        bw.write(count + "");
        bw.flush();
    }
}