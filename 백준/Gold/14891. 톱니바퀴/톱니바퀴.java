import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] gears;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        gears = new int[5][9];

        for (int i = 1; i <= 4; i++) {
            String state = br.readLine();
            for (int j = 1; j <= 8; j++) {
                gears[i][j] = state.charAt(j - 1) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());

        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int targetGear = Integer.parseInt(st.nextToken());
            int turnDirection = Integer.parseInt(st.nextToken());
            check(targetGear - 1, gears[targetGear][7], 1,turnDirection * -1);      // 왼쪽 톱니바퀴 확인
            check(targetGear + 1, gears[targetGear][3], 2,turnDirection * -1);      // 오른쪽 톱니바퀴 확인
            turn(targetGear, turnDirection);
        }

        int answer = 0;

        for (int i = 1; i <= 4; i++) {
            if (gears[i][1] == 1) {
                if (i == 1) {
                    answer += 1;
                } else if (i == 2) {
                    answer += 2;
                } else if (i == 3) {
                    answer += 4;
                } else {
                    answer += 8;
                }
            }
        }

        bw.write(answer + "");
        bw.flush();
    }

    static void turn(int gear, int direction) {
        if(direction == 1) {    // 시계 방향
            int last = gears[gear][8];
            for (int i = 8; i >= 2; i--) {
                gears[gear][i] = gears[gear][i - 1];
            }
            gears[gear][1] = last;

        } else {                // 반시계 방향
            int first = gears[gear][1];
            for (int i = 1; i <= 7; i++) {
                gears[gear][i] = gears[gear][i + 1];
            }
            gears[gear][8] = first;
        }
    }

    static void check(int gear, int previousState, int checkDirection, int turnDirection) {
        if(gear == 0 || gear == 5) {
            return;
        }

        if (checkDirection == 1) {   // 왼쪽
            if (gears[gear][3] != previousState) {
                check(gear - 1, gears[gear][7], 1, turnDirection * -1);
                turn(gear, turnDirection);
            }

        } else {                    // 오른쪽
            if (gears[gear][7] != previousState) {
                check(gear + 1, gears[gear][3], 2, turnDirection * -1);
                turn(gear, turnDirection);
            }
        }
    }
}