import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int l, c;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[c];
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        char[] answer = new char[l];
        recursive(answer, 0);

        bw.flush();
    }

    static void recursive(char[] answer, int pos) throws IOException {
        if (pos == answer.length) {
            int moum = 0;
            int zaum = 0;
            Set<Character> set = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));

            for (int i = 0; i < l - 1; i++) {
                if (set.contains(answer[i])) {
                    moum++;
                } else {
                    zaum++;
                }

                if (answer[i] > answer[i + 1]) {
                    return;
                }
            }

            if (set.contains(answer[l - 1])) {
                moum++;
            } else {
                zaum++;
            }

            if (moum >= 1 && zaum >= 2) {
                bw.write(new String(answer) + "\n");
            }

            return;
        }

        for (int i = 0; i < c; i++) {
            if (pos != 0 && answer[pos - 1] >= arr[i]) {
                continue;
            }
            answer[pos] = arr[i];
            recursive(answer, pos + 1);
        }
    }
}