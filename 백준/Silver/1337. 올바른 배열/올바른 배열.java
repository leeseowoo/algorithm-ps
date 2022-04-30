import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);

        int[] fiveValues = new int[5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                fiveValues[j] = input[i] + j;
            }

            int count = 0;
            for (int j = 0; j < 5; j++) {
                for (int k = j; k < 5; k++) {
                    if (i + j < n && input[i + j] == fiveValues[k]) {
                        count++;
                        break;
                    }
                }
            }

            answer = Math.min(5 - count, answer);
        }

        bw.write(answer + "");
        bw.flush();
    }
}