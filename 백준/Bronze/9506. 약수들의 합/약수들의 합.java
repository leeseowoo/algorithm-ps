import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 0;

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }

            int sqrt = (int) Math.sqrt(n);
            List<Integer> divisor = new ArrayList<>();
            divisor.add(1);

            for (int i = 2; i <= sqrt; i++) {
                if (n % i == 0) {
                    divisor.add(i);
                    if (n / i != i) {
                        divisor.add(n / i);
                    }
                }
            }

            if (divisor.stream().mapToInt(Integer::intValue).sum() == n) {  // true: 완전수
                divisor.sort(Comparator.naturalOrder());
                int size = divisor.size();
                bw.write(n + " = ");

                for (int i = 0; i < size - 1; i++) {
                    bw.write(divisor.get(i) + " + ");
                }
                bw.write(divisor.get(size-1) + "\n");

            } else {
                bw.write(n + " is NOT perfect.\n");
            }
        }

        bw.flush();
    }
}