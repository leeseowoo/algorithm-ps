import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int n, m;
    static List<Integer> numbers = new ArrayList<>();
    static Integer[] elements;
    static List<List<Integer>> permutation = new ArrayList<>();

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

    public static void getPermutation(int depth) {
        if (depth == m) {
            permutation.add(new ArrayList<>(Arrays.stream(elements).collect(Collectors.toList())));
            return;
        }

        for (int i = 0; i < n; i++) {
            elements[depth] = numbers.get(i);
            getPermutation(depth + 1);
        }
    }
}