import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        parents = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {
            bw.write(parents[i] + "\n");
        }
        bw.flush();
    }

    static void dfs(int currentNode) {
        visited[currentNode] = true;

        for (int node : graph.get(currentNode)) {
            if (!visited[node]) {
                dfs(node);
                parents[node] = currentNode;
            }
        }
    }
}