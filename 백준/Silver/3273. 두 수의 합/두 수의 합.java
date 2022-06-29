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
        int target = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = n - 1;
        int cnt = 0;
        Arrays.sort(arr);

        while(s < e) {
            int sum = arr[s] + arr[e];

            if(sum == target) {
                cnt++;
                s++;
                e--;
            } else if(sum > target) {
                e--;
            } else if(sum < target) {
                s++;
            }
        }

        bw.write(cnt + "");
        bw.flush();
    }
}