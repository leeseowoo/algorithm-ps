import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    // 숫자 카드 개수
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());    // 찾을 횟수
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            int card = Integer.parseInt(st.nextToken());
            if(set.contains(card)) {
                answer.add(1);
            } else {
                answer.add(0);
            }
        }

        for(int i = 0; i < m - 1; i++) {
            bw.write(answer.get(i) + " ");
        }
        bw.write(answer.get(m - 1) + "");
        bw.flush();
    }
}