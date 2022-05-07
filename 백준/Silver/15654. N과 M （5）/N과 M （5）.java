import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[] checked;
    static List<Integer> input = new ArrayList<>();
    static List<Integer> elements = new ArrayList<>();
    static List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        checked = new boolean[n];

        for (int i = 0; i < n; i++) {
            input.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(input);

        recursive(0);

        for (List<Integer> list : answer) {
            for (int i = 0; i < m - 1; i++) {
                bw.write(list.get(i) + " ");
            }
            bw.write(list.get(m - 1) + "\n");
        }
        bw.flush();
    }

    public static void recursive(int position) {
        if (position == m) {
            answer.add(new ArrayList<>(elements));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (checked[i] == false) {
                elements.add(input.get(i));
                checked[i] = true;
                recursive(position + 1);
                elements.remove(position);
                checked[i] = false;
            }
        }
    }
}