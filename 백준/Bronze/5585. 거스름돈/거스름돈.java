import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int price = Integer.parseInt(br.readLine());
        int[] coins = new int[]{500, 100, 50, 10, 5, 1};
        int index = 0;
        int change = 1000 - price;
        int globalCount = 0;

        while (change > 0) {
            int localCount = change / coins[index];

            if (localCount >= 1) {
                globalCount += localCount;
                change -= coins[index] * localCount;
            }

            index++;
        }

        bw.write(globalCount + "");
        bw.flush();
    }
}