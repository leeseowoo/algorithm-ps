import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer> answer = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    bfs(i, j, graph);
                }
            }
        }

        Collections.sort(answer);

        bw.write(answer.size() + "\n");
        for (int i : answer) {
            bw.write(i + "\n");
        }

        bw.flush();
    }

    public static void bfs(int startX, int startY, int[][] graph) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int house = 0;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            graph[x][y] = 0;
            house++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx == -1 || ny == -1 || nx >= n || ny >= n || graph[nx][ny] == 0) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        answer.add(house);
    }
}