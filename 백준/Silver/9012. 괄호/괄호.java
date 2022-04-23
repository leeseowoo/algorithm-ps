import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            checkVps(input);
        }

        bw.flush();
    }

    public static void checkVps(String s) throws IOException {
        Deque<Integer> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offerFirst(1);

            } else {
                if (stack.isEmpty()) {
                    bw.write("NO\n");
                    return;
                }

                stack.pollFirst();
            }
        }

        if (stack.isEmpty()) {
            bw.write("YES\n");
        } else {
            bw.write("NO\n");
        }
    }
}