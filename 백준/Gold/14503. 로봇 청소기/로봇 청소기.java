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
        int[][] room = new int[n][m];

        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());   // 바라보는 방향, 0: 북, 1: 동, 2: 남, 3:서

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(bfs(r, c, d, room) + "");
        bw.flush();
    }

    static int bfs(int startX, int startY, int d, int[][] room) {
        int count = 0;
        int[] dx = new int[]{0, -1, 0, 1};      // 서, 북, 동, 남
        int[] dy = new int[]{-1, 0, 1, 0};
        int[] turn = new int[]{3, 0, 1, 2};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        room[startX][startY] = 2;
        count++;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i <= 3; i++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                d = turn[d];
                if (room[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                    room[nx][ny] = 2;
                    count++;
                    break;
                }
                if (i == 3) {
                    int bx = x + dx[turn[d]];
                    int by = y + dy[turn[d]];
                    if (room[bx][by] == 1) {
                        return count;
                    } else {
                        q.offer(new int[]{bx, by});
                    }
                }
            }
        }

        return count;
    }
}