import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int n, m;                    // 지도 크기
    static int diceX, diceY;            // 주사위 위치
    static int k;                       // 명령 개수
    static int[][] map;                 // 지도
    static int[] dice = new int[7];     // 주사위 전개도
    static int[] dx = new int[]{0, 0, 0, -1, 1};
    static int[] dy = new int[]{0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        diceX = Integer.parseInt(st.nextToken());
        diceY = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        while (k-- > 0) {
            int command = Integer.parseInt(st.nextToken());
            int result = start(command);
            if (result != -1) {
                bw.write(result + "\n");
            }
        }

        bw.flush();
    }

    public static int start(int command) {
        if (move(command) == -1) {
            return -1;
        }

        int temp;
        switch (command) {
            case 1:
                temp = dice[6];
                dice[6] = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[4];
                dice[4] = temp;
                break;
            case 2:
                temp = dice[6];
                dice[6] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[3];
                dice[3] = temp;
                break;
            case 3:
                temp = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = temp;
                break;
            case 4:
                temp = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
                break;
        }

        if (map[diceX][diceY] == 0) {
            map[diceX][diceY] = dice[6];
        } else {
            dice[6] = map[diceX][diceY];
            map[diceX][diceY] = 0;
        }

        return dice[1];
    }

    public static int move(int direction) {
        int nx = diceX + dx[direction];
        int ny = diceY + dy[direction];

        if (nx <= -1 || ny <= -1 || nx >= n || ny >= m) {
            return -1;
        }

        diceX = nx;
        diceY = ny;

        return 0;
    }
}