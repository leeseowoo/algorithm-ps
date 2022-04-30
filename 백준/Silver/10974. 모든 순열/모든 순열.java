import java.io.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        boolean[] used = new boolean[n];

        recursive(answer, 0, used);

        bw.flush();
    }

    static void recursive(int[] answer, int pos, boolean[] used) throws IOException {
        if (pos == n) {
            for (int i = 0; i < n-1; i++) {
                bw.write(answer[i] + " ");
            }
            bw.write(answer[n-1] + "\n");
        }

        for (int i = 0; i < n; i++) {
            if (used[i] == false) {
                answer[pos] = i + 1;
                used[i] = true;
                recursive(answer, pos + 1, used);
                used[i] = false;
            }
        }
    }
}