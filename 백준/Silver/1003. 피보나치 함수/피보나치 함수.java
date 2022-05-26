import java.io.*;
import java.util.Arrays;

public class Main {

    static int[] answer = new int[2];
    static int[] cache = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Arrays.fill(answer, 0);
            fibonacci(n);
            bw.write(answer[0] + " " + answer[1] + "\n");
        }
        bw.flush();
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            answer[0]++;
            cache[0] = 0;
            return 0;
        } else if (n == 1) {
            answer[1]++;
            cache[1] = 1;
            return 1;
        }

        if (cache[n] != 0) {
            answer[0] += cache[n - 1];
            answer[1] += cache[n];
        } else {
            cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return cache[n];
    }
}