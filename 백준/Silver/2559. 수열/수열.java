import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] temperature = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 0; i < k; i++) {
            answer += temperature[i];
        }

        int start = 0;
        int end = k - 1;
        int sum = answer;
        while (end < n - 1) {
            sum = sum - temperature[start++] + temperature[++end];
            answer = Math.max(answer, sum);
        }

        bw.write(answer + "");
        bw.flush();
    }
}