import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());    // 사과 개수
        int[][] map = new int[n + 1][n + 1];

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 4;    // 사과 위치
        }

        int l = Integer.parseInt(br.readLine());    // 방향 변환 횟수
        int[][] commands = new int[l][2];
        for(int i = 0; i < l; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            commands[i][0] = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            if (d.equals("L")) {
                commands[i][1] = 1;     // 왼쪽
            } else {
                commands[i][1] = 2;     // 오른쪽
            }
        }

        bw.write(startGame(map, n, commands, l) + "");
        bw.flush();
    }

    static int startGame(int[][] map, int n, int[][] commands, int l) {
        int[] dx = new int[]{-1, 0, 1, 0};      // 상, 우, 하, 좌
        int[] dy = new int[]{0, 1, 0, -1};
        int x = 1, y = 1;
        int time = 0;
        int p = 0;
        int currD = 1;      // 처음에 오른쪽을 바라봄
        boolean flag = true;
        Queue<int[]> snake = new LinkedList<>();
        snake.offer(new int[]{x, y});   // 뱀 초기 위치

        while(flag) {
            if(p < l && time == commands[p][0]) {            // 방향 회전
                if(commands[p][1] == 1) {           // 왼쪽
                    currD -= 1;
                    if(currD == -1) currD = 3;
                } else {                            // 오른쪽
                    currD += 1;
                    if(currD == 4) currD = 0;
                }
                p++;
            }

            int nx = x + dx[currD];
            int ny = y + dy[currD];

            if(nx < 1 || ny < 1 || nx > n || ny > n) {
                flag = false;

            } else {
                int size = snake.size();

                while(size-- > 0) {
                    int[] body = snake.poll();
                    int bx = body[0];
                    int by = body[1];

                    if(nx == bx && ny == by) {
                        flag = false;
                        break;
                    }

                    snake.offer(body);
                }

                if(map[nx][ny] == 4) {      // 사과 발견
                    map[nx][ny] = 0;
                } else {
                    snake.poll();
                }

                snake.offer(new int[]{nx, ny});
                x = nx;
                y = ny;
            }

            time++;
        }

        return time;
    }
}