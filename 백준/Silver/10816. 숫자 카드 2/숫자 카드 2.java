import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            int card = Integer.parseInt(st.nextToken());
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(st.nextToken());
            answer.add(map.getOrDefault(card, 0));
        }

        for (int i = 0; i < m - 1; i++) {
            bw.write(answer.get(i) + " ");
        }
        bw.write(answer.get(m - 1) + "");
        bw.flush();
    }
}