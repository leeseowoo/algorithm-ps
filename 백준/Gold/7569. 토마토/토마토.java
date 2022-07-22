import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] map;
    static int h, n ,m;
    static int answer;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        if (firstStep()) {  // 초기 상태에서, 익은 토마토 위치 큐에 추가, 이미 모두 익어있는 상태일 경우 true 반환
            answer = 0;
        } else {
            bfs();
            lastStep();     // 안 익은 토마토가 있는지 확인
        }

        bw.write(answer + "");
        bw.flush();
    }

    static void bfs() {
        int[] dh = new int[]{0, 0, 0, 0, -1, 1};
        int[] dx = new int[]{-1, 1, 0, 0, 0, 0};    // 상 하 좌 우 아래 위
        int[] dy = new int[]{0, 0, -1, 1, 0, 0};

        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                int[] curr = q.poll();
                int ch = curr[0];
                int cx = curr[1];
                int cy = curr[2];

                for(int i = 0; i < 6; i++) {
                    int nh = ch + dh[i];
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nh < 0 || nh >= h || nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }

                    if (map[nh][nx][ny] == 0) {
                        map[nh][nx][ny] = 1;
                        q.offer(new int[]{nh, nx, ny});
                    }
                }
            }

            answer += 1;
        }

        answer -= 1;
    }

    static boolean firstStep() {
        boolean foundZero = false;

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(map[i][j][k] == 1) {
                        q.offer(new int[]{i, j, k});
                    } else if(map[i][j][k] == 0) {
                        foundZero = true;
                    }
                }
            }
        }

        if (!foundZero) {    // 이미 모두 익어있는 상태
            return true;
        } else {
            return false;
        }
    }

    static void lastStep() {
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < m; k++) {
                    if(map[i][j][k] == 0) {
                        answer = -1;
                        return;
                    }
                }
            }
        }
    }
}