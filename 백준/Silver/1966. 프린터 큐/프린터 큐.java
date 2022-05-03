import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            Queue<Integer[]> queue = new LinkedList<>();
            Integer[] sorted = new Integer[n];

            for (int i = 0; i < n; i++) {
                int document = Integer.parseInt(st.nextToken());
                if (i == m) {
                    queue.offer(new Integer[]{document, 1});    // [1] == 1인 원소 : 몇 번째로 인쇄되는지 알고 싶은 원소
                } else {
                    queue.offer(new Integer[]{document, 0});
                }
                sorted[i] = document;
            }

            Arrays.sort(sorted, Comparator.reverseOrder());
            int ptr = 0;
            int count = 0;

            while (true) {
                if (queue.peek()[0] < sorted[ptr]) {
                    queue.offer(queue.poll());
                } else {
                    ptr++;
                    count++;
                    if (queue.poll()[1] == 1) {
                        break;
                    }
                }
            }

            bw.write(count + "\n");
        }

        bw.flush();
    }
}