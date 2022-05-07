import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int number = 665;
        int count = 0;

        while (count < n) {
            number++;
            String s = String.valueOf(number);
            if (s.contains("666")) {
                count++;
            }
        }

        bw.write(number + "");
        bw.flush();
    }
}