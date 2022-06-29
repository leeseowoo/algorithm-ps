import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> network;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine());    // 연결된 컴퓨터 쌍의 수
        visited = new boolean[n + 1];
        network = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            network.add(new ArrayList<>());
        }

        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network.get(a).add(b);
            network.get(b).add(a);
        }

        dfs(1);

        bw.write(answer - 1 + "");
        bw.flush();
    }

    static void dfs(int node) {
        visited[node] = true;
        answer++;

        int size = network.get(node).size();

        for(int i = 0; i < size; i++) {
            if(!visited[network.get(node).get(i)]) {
                dfs(network.get(node).get(i));
            }
        }
    }
}