import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    count++;
                }
            }

            arr[i][2] = count + 1;
        }

        for (int i = 0; i < n - 1; i++) {
            bw.write(arr[i][2] + " ");
        }
        bw.write(arr[n-1][2] + "");
        bw.flush();
    }
}