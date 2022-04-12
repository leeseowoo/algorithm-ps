import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        bw.write(min + " " + max);
        bw.flush();
        bw.close();
        br.close();
    }
}