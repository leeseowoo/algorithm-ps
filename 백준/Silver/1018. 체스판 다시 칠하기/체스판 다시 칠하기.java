import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int endI = i + 7, endJ = j + 7;
                if (endI >= n || endJ >= m) {
                    continue;
                }
                min = Math.min(min, check(i, j, endI, endJ));
            }
        }

        bw.write(min + "");
        bw.flush();
    }

    public static int check(int startI, int startJ, int endI, int endJ) {
        int[] count = new int[2];
        char previous = 'S';

        for (int i = startI; i <= endI; i++) {
            for (int j = startJ; j <= endJ; j++) {
                if (board[i][j] == previous) {
                    count[0]++;
                    if (board[i][j] == 'W') {
                        previous = 'B';
                    } else {
                        previous = 'W';
                    }
                } else {
                    previous = board[i][j];
                    count[1]++;
                }
            }

            if (previous == 'W') {
                previous = 'B';
            } else {
                previous = 'W';
            }
        }

        return Math.min(count[0], count[1]);
    }
}