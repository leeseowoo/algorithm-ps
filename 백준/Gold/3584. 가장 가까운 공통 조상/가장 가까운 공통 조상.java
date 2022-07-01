import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            Set<Integer> set = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            int[] parents = new int[n + 1];

            for (int i = 1; i <= n - 1; i++) {
                String in = br.readLine();
                String[] nodes = in.split(" ");
                int a = Integer.parseInt(nodes[0]);     // 부모
                int b = Integer.parseInt(nodes[1]);     // 자식

                parents[b] = a;
            }

            String in = br.readLine();
            String[] targets = in.split(" ");
            int a = Integer.parseInt(targets[0]);
            int b = Integer.parseInt(targets[1]);
            set.add(a);
            set.add(b);

            int p = parents[a];
            while(p != 0) {
                if(set.contains(p)) {
                    bw.write(p + "\n");
                    break;
                }
                set.add(p);
                p = parents[p];
            }

            p = parents[b];
            while (p != 0) {
                if(set.contains(p)) {
                    bw.write(p + "\n");
                    break;
                }
                set.add(p);
                p = parents[p];
            }
        }

        bw.flush();
    }
}