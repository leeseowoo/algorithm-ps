import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int n, m;
    static Queue<int []> q = new LinkedList<>();
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(firstStep()) {       // 익은 토마토 위치 큐에 추가, 안 익은 토마토가 있으면 true 반환
            bfs();
            lastStep();         // 안 익은 토마토가 남아있는지 확인
        } else {
            answer = 0;         // 이미 모두 익어있는 경우 0
        }

        bw.write(answer + "");
        bw.flush();
    }

    static void bfs() {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int days = 0;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            days = map[x][y];

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if(map[nx][ny] == 0) {
                    map[nx][ny] = days + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        answer = days - 1;
    }

    static boolean firstStep() {
        boolean foundZero = false;

        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1) {
                    q.offer(new int[]{i, j});
                } else if(map[i][j] == 0) {
                    foundZero = true;
                }
            }
        }

        return foundZero;
    }

    static void lastStep() {
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    answer = -1;
                    return;
                }
            }
        }
    }
}