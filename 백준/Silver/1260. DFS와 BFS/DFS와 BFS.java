import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m, v;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());   // 정점 개수
        m = Integer.parseInt(st.nextToken());   // 간선 개수
        v = Integer.parseInt(st.nextToken());   // 탐색 시작 정점
        visited = new boolean[n + 1];
        answer = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i <=n; i++) {
            graph.add(new ArrayList<>());
        }

        // 정점 연결
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        for (List<Integer> list : graph) {
            Collections.sort(list);
        }

        dfs(v);
        printAnswer();
        bfs(v);
        printAnswer();
        bw.flush();
    }

    public static void dfs(int x) {
        visited[x] = true;
        answer.add(x);

        int size = graph.get(x).size();
        for (int i = 0; i < size; i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) {
                dfs(y);
            }
        }
    }

    public static void bfs(int start) {
        Arrays.fill(visited, false);
        answer.clear();

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            answer.add(current);

            int size = graph.get(current).size();
            for (int i = 0; i < size; i++) {
                int y = graph.get(current).get(i);
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void printAnswer() throws IOException {
        int size = answer.size();
        for (int i = 0; i < size - 1; i++) {
            bw.write(answer.get(i) + " ");
        }
        bw.write(answer.get(size - 1) + "\n");
    }
}