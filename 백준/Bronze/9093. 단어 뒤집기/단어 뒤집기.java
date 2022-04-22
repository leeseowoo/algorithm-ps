import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {

            String str = br.readLine() + "\n";

            Stack<Character> stack = new Stack<>();
            for (char ch : str.toCharArray()) {
                if (ch == ' ' || ch == '\n') {
                    while (!stack.empty()) {
                        bw.write(stack.pop());
                    }
                    bw.write(ch);

                } else {
                    stack.push(ch);
                }
            }
        }

        bw.flush();
    }
}