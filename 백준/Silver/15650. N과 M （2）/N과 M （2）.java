import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static int n, m;
    static List<Integer> numbers = new ArrayList<>();
    static List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());   // 1~n
        m = Integer.parseInt(st.nextToken());   // m개 선택

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        backtrack(0);

        List<String> output = answer.stream()
                .map(list -> list.stream()
                        .map(e -> String.valueOf(e))
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.toList());

        Collections.sort(output);

        for (String s : output) {
            bw.write(s + "\n");
        }

        bw.flush();
    }

    public static void backtrack(int first) {
        if (first == m) {
            List<Integer> newNumbers = new ArrayList<>();
            int previous = Integer.MIN_VALUE;
            boolean flag = true;

            for (int i = 0; i < m; i++) {
                int current = numbers.get(i);
                if (current < previous) {
                    flag = false;
                    break;
                }
                newNumbers.add(current);
                previous = current;
            }

            if (flag) {
                answer.add(new ArrayList<>(newNumbers));
            }

            return;
        }

        for (int i = first; i < n; i++) {
            Collections.swap(numbers, i, first);
            backtrack(first + 1);
            Collections.swap(numbers, i, first);
        }
    }
}