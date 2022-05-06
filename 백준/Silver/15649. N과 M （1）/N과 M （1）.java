import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    static List<Integer> numbers = new ArrayList<>();
    static List<List<Integer>> permutation = new ArrayList<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            numbers.add(i + 1);
        }

        getPermutation(0);

        List<String> answer = permutation.stream()
                .map(list -> list.stream()
                        .map(e -> String.valueOf(e))
                        .collect(Collectors.joining(" ")))
                .collect(Collectors.toList());

        Collections.sort(answer);

        for (String output : answer) {
            bw.write(output + "\n");
        }

        bw.flush();
    }

    public static void getPermutation(int first) {
        if (first == m) {
            List<Integer> newNumbers = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                newNumbers.add(numbers.get(i));
            }
            permutation.add(new ArrayList<>(newNumbers));
            return;
        }

        for (int i = first; i < n; i++) {
            Collections.swap(numbers, i, first);
            getPermutation(first + 1);
            Collections.swap(numbers, i, first);
        }
    }
}