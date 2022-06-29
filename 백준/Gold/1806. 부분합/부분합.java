import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;     // 최소 길이
        int s = 0, e = 0;
        int sum = arr[e];

        while(s <= e && e < n) {
            if(sum >= target) {
                answer = Math.min(answer, (e - s) + 1);
                sum -= arr[s];
                s++;

            } else if(sum < target) {
                e++;
                if(e == n) {
                    break;
                }
                sum += arr[e];
            }
        }

        if(answer == Integer.MAX_VALUE) {
            answer = 0;
        }

        bw.write(answer + "");
        bw.flush();
    }
}