import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int n, m;
    static List<Integer> numbers = new ArrayList<>();
    static Integer[] elements;
    static List<List<Integer>> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        elements = new Integer[m];

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        recursive(0, 0);

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

    public static void recursive(int depth, int previous) {
        if (depth == m) {
            answer.add(new ArrayList<>(Arrays.stream(elements).collect(Collectors.toList())));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (numbers.get(i) < numbers.get(previous)) {
                continue;
            }
            elements[depth] = numbers.get(i);
            recursive(depth + 1, i);
        }
    }
}