import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] numbers = new int[10];
        String input = br.readLine();

        for(char c : input.toCharArray()) {
            numbers[c - '0']++;
        }

        if((numbers[6] + numbers[9]) % 2 == 0) {
            numbers[6] = (numbers[6] + numbers[9]) / 2;
        } else {
            numbers[6] = (numbers[6] + numbers[9]) / 2 + 1;
        }
        numbers[9] = numbers[6];

        int max = Integer.MIN_VALUE;

        for(int n : numbers) {
            if(n > max) {
                max = n;
            }
        }

        bw.write(max + "");
        bw.flush();
    }
}