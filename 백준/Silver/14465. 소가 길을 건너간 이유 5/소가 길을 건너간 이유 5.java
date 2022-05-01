import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] broken = new int[b];

        for (int i = 0; i < b; i++) {
            broken[i] = Integer.parseInt(br.readLine());
            arr[broken[i] - 1] = -1;
        }

        int x = 0;
        for (int i = 0; i < k; i++) {
            if (arr[i] == -1) {
                x++;
            }
        }

        int start = 0;
        int end = k;
        int answer = x;

        while (end < n) {
            answer = Math.min(answer, x);

            if (arr[start++] == -1) {
                x--;
            }

            if (arr[end++] == -1) {
                x++;
            }
        }

        bw.write(Math.min(answer, x) + "");
        bw.flush();
    }
}