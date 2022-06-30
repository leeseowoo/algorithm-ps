import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> answer = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {
            q.offer(i);
        }

        int cnt = 1;
        while(!q.isEmpty()) {
            if(cnt == k) {
                answer.add(q.poll());
                cnt = 0;
            } else {
                q.offer(q.poll());
            }
            cnt++;
        }

        bw.write("<");
        for(int i = 0; i < n - 1; i++) {
            bw.write(answer.get(i) + ", ");
        }
        bw.write(answer.get(n - 1) + ">");
        bw.flush();
    }
}