import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static List<Integer> numbers = new ArrayList<>();
    static List<List<Integer>> answer = new ArrayList<>();
    static List<Integer> elements = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(numbers);

        getPermutation(0);

        for (List<Integer> list : answer) {
            int size = list.size();
            for (int i = 0; i < size - 1; i++) {
                bw.write(list.get(i) + " ");
            }
            bw.write(list.get(size - 1) + "\n");
        }

        bw.flush();
    }

    public static void getPermutation(int depth) {
        if (depth == m) {
            answer.add(new ArrayList<>(elements));
            return;
        }

        for (int i = 0; i < n; i++) {
            elements.add(numbers.get(i));
            getPermutation(depth + 1);
            elements.remove(depth);
        }
    }
}