import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;

        while (n-- > 0) {
            int current = Integer.parseInt(st.nextToken());
            if (current == 1) {
                continue;
            }

            int sqrt = (int) Math.sqrt(current);
            boolean flag = false;

            for (int i = 2; i <= sqrt; i++) {
                if (current % i == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                count++;
            }
        }

        bw.write(count + "");
        bw.flush();
    }
}