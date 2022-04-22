import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        Deque<Character> stack = new ArrayDeque<>();

        while (t-- > 0) {
            String input = br.readLine() + "\n";

            for (char c : input.toCharArray()) {
                if (c == ' ' || c == '\n') {
                    while (!stack.isEmpty()) {
                        bw.write(stack.pollFirst());
                    }
                    bw.write(c);

                } else {
                    stack.offerFirst(c);
                }
            }
        }

        bw.flush();
    }
}