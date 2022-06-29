import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int a = 0, b = 0;
        int s = 0, e = n - 1;
        int sum = Integer.MAX_VALUE;
        Arrays.sort(arr);

        while(s < e) {
            if(arr[s] + arr[e] == 0) {
                a = arr[s];
                b = arr[e];
                break;
            } else if(arr[s] + arr[e] < 0) {
                int abs = Math.abs(arr[s] + arr[e]);
                if(abs < sum) {
                    sum = abs;
                    a = arr[s];
                    b = arr[e];
                }
                s++;
            } else if(arr[s] + arr[e] > 0) {
                int abs = Math.abs(arr[s] + arr[e]);
                if(abs < sum) {
                    sum = abs;
                    a = arr[s];
                    b = arr[e];
                }
                e--;
            }
        }

        bw.write(a + " " + b);
        bw.flush();
    }
}