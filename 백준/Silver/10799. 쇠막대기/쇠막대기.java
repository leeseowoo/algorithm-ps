import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        boolean isOpened = true;
        int rod = 0, result = 0;


        for (char c : input.toCharArray()) {
            if (c == '(') {
                isOpened = true;
                rod += 1;

            } else {
                if (isOpened) {
                    rod -= 1;
                    result += rod;

                } else {
                    result += 1;
                    rod -= 1;
                }

                isOpened = false;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
    }
}