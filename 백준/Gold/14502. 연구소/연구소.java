import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int[][] copiedMap;
    static int n, m;
    static int globalZeroCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copiedMap = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtrack(1);

        bw.write(globalZeroCnt + "");
        bw.flush();
    }

    public static void backtrack(int wall) {
        if(wall == 4) {
            copy();
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    backtrack(wall + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public static void copy() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copiedMap[i][j] = map[i][j];
            }
        }
    }

    public static void bfs() {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copiedMap[i][j] == 2) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] current = q.poll();
                        int x = current[0];
                        int y = current[1];

                        for (int k = 0; k <= 3; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                                continue;
                            }

                            if(copiedMap[nx][ny] == 0) {
                                copiedMap[nx][ny] = 2;
                                q.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        count();
    }

    public static void count() {
        int localZeroCnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copiedMap[i][j] == 0) {
                    localZeroCnt++;
                }
            }
        }

        if (localZeroCnt > globalZeroCnt) {
            globalZeroCnt = localZeroCnt;
        }
    }
}