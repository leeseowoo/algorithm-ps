import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String before = br.readLine();
        Deque<Character> after = new ArrayDeque<>();

        for (char c : before.toCharArray()) {
            while (k > 0 && !after.isEmpty() && after.getLast() < c) {
                after.removeLast();
                k--;
            }
            after.addLast(c);
        }

        while (after.size() > k) {
            bw.write(after.removeFirst());
        }
        bw.flush();
    }
}