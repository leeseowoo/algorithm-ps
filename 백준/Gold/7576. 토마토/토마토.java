import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static int[][] storage;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static boolean[][] visited;
    static boolean[][] anotherVisited;
    static Queue<int[]> queue = new LinkedList<>();
    static Queue<int[]> anotherQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        storage = new int[n][m];
        visited = new boolean[n][m];
        anotherVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storage[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    anotherQueue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    anotherVisited[i][j] = true;
                }
            }
        }

        int days = 0;
        int status = checkStatus();

        if (status == 1) {
            days = bfs() - 1;
        } else {
            days = status;
        }

        bw.write(days + "");
        bw.flush();
    }

    public static int checkStatus() {
        boolean foundZero = false;

        while (!anotherQueue.isEmpty()) {
            int[] currnet = anotherQueue.poll();
            int x = currnet[0];
            int y = currnet[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx <= -1 || ny <= -1 || nx >= n || ny >= m) {
                    continue;
                }

                if (storage[x][y] == -1 && storage[nx][ny] == 0) {
                    continue;
                }

                if (!anotherVisited[nx][ny]) {
                    anotherVisited[nx][ny] = true;
                    anotherQueue.offer(new int[]{nx, ny});
                    if (storage[nx][ny] == 0) {
                        foundZero = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!anotherVisited[i][j]) {
                    return -1;
                }
            }
        }

        if (!foundZero) {
            return 0;
        }

        return 1;
    }

    public static int bfs() {
        int days = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            days = storage[x][y];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx <= -1 || ny <= -1 || nx >= n || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (storage[nx][ny] == 0) {
                        storage[nx][ny] = storage[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }

        return days;
    }
}