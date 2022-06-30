import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    // 용액의 수
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0, p2 = n - 1;
        int a = 0, b = 0;
        int ans = Integer.MAX_VALUE;

        while (p1 < p2) {
            int sum = arr[p1] + arr[p2];
            int abs = Math.abs(sum);

            if (abs < ans) {
                ans = abs;
                a = arr[p1];
                b = arr[p2];
            }

            if(sum == 0) {
                a = arr[p1];
                b = arr[p2];
                break;

            } else if(sum < 0) {
                p1++;

            } else if(sum > 0) {
                p2--;

            }
        }

        bw.write(a + " " + b);
        bw.flush();
    }
}