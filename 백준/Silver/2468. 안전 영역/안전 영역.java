import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        boolean[] check = new boolean[101];
        check[0] = true;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < n; j++) {
                int k = Integer.parseInt(st.nextToken());
                check[k] = true;
                map[i][j] = k;
            }
        }

        int global = 0;

        for(int k = 0; k <= 100; k++) {
            if(!check[k]) {
                continue;
            }

            int local = 0;
            boolean[][] visited = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] > k && !visited[i][j]) {
                        bfs(i, j, k, map, n, visited);
                        local++;
                    }

                }
            }

            global = Math.max(global, local);
        }

        bw.write(global + "");
        bw.flush();
    }

    static void bfs(int startX, int startY, int k, int[][] map, int n, boolean[][] visited) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }

                if(map[nx][ny] > k && !visited[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}