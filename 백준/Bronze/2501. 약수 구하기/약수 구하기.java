import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int squareRoot = (int) Math.sqrt(n);
        ArrayList<Integer> divisor = new ArrayList<>();

        for (int i = 1; i <= squareRoot; i++) {
            if (n % i == 0) {
                divisor.add(i);

                if (n / i != i) {
                    divisor.add(n / i);
                }
            }
        }

        if (divisor.size() < k) {
            bw.write(0 + "");
        } else {
            divisor.sort(Comparator.naturalOrder());
            bw.write(divisor.get(k - 1) + "");
        }

        bw.flush();
    }
}