import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] numbers;
    static int n, s;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        numbers = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        bw.write(answer + "");
        bw.flush();
    }

    static void dfs(int index, int sum) {
        if (index == n) {
            return;
        }

        sum += numbers[index];

        if (sum == s) {
            answer++;
        }

        dfs(index + 1, sum);
        dfs(index + 1, sum - numbers[index]);
    }
}