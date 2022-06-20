import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] costA = new int[n][m];
        int[][] costB = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0, costA, map, n, m);
        bfs(n - 1, m - 1, costB, map, n, m);

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (costA[i][j] == 0 || costB[i][j] == 0) {
                    continue;
                }
                if (costA[i][j] + costB[i][j] < answer) {
                    answer = costA[i][j] + costB[i][j];
                }
            }
        }

        if (answer == Integer.MAX_VALUE) {
            answer = -1;
        } else {
            answer -= 1;
        }

        bw.write(answer + "");
        bw.flush();
    }

    public static void bfs(int startX, int startY, int[][] cost, int[][] map, int n, int m) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        cost[startX][startY] = 1;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i <= 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (cost[nx][ny] == 0) {
                    if(map[nx][ny] == 0) {
                        q.offer(new int[]{nx, ny});
                    }
                    cost[nx][ny] = cost[x][y] + 1;
                }
            }
        }
    }
}