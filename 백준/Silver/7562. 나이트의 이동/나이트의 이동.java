import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int l;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int startX, startY;
    static int goalX, goalY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            l = Integer.parseInt(br.readLine());
            board = new int[l][l];
            visited = new boolean[l][l];

            st = new StringTokenizer(br.readLine(), " ");
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            int distance = bfs(startX, startY);
            bw.write(distance + "\n");
        }

        bw.flush();
    }

    public static int bfs(int startX, int startY) {
        if (startX == goalX && startY == goalY) {
            return 0;
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nd = distance + 1;

                if (nx <= -1 || ny <= -1 || nx >= l || ny >= l) {
                    continue;
                }

                if (nx == goalX && ny == goalY) {
                    return nd;
                }

                if (!visited[nx][ny]) {
                    q.offer(new int[]{nx, ny, nd});
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;
    }
}