import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    // m의 분해합
        int answer = 0;

        for (int i = 1; i < n; i++) {
            int number = i;
            int sum = 0;    // i의 각 자리수 합

            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }

            if (sum + i == n) {
                answer = i;
                break;
            }
        }
        bw.write(answer + "");
        bw.flush();
    }
}