import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        StringTokenizer divisor = new StringTokenizer(br.readLine(), " ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while (k-- > 0) {
            int value = Integer.parseInt(divisor.nextToken());
            max = Math.max(value, max);
            min = Math.min(value, min);
        }

        bw.write(max * min + "");
        bw.flush();
    }
}