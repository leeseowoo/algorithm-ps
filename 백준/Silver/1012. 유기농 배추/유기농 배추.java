import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        int[] answer = new int[tc];
        int idx = 0;

        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());   // 열
            int n = Integer.parseInt(st.nextToken());   // 행
            int b = Integer.parseInt(st.nextToken());   // 배추 개수
            int[][] map = new int[n][m];

            while(b-- > 0) {
                st = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st.nextToken());   // 열 위치
                int x = Integer.parseInt(st.nextToken());   // 행 위치
                map[x][y] = 1;
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] == 1) {    // 배추 발견
                        bfs(i, j, n, m, map);
                        answer[idx]++;
                    }
                }
            }

            idx++;
        }

        for(int i : answer) {
            bw.write(i + "\n");
        }

        bw.flush();
    }

    static void bfs(int startX, int startY, int n, int m, int[][] map) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        map[startX][startY] = -1;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if(map[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    map[nx][ny] = -1;
                }
            }
        }
    }
}