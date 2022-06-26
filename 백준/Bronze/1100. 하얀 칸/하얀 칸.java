import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[][] board = new char[9][9];

        for(int i = 1; i <= 8; i++) {
            String line = br.readLine();
            for(int j = 1; j <= 8; j++) {
                board[i][j] = line.charAt(j-1);
            }
        }

        int count = 0;
        int flag = 1;

        for(int i = 1; i <= 8; i++) {
            for(int j = 1; j <= 8; j++) {
                if(flag == 1 && j % 2 != 0) {
                    if(board[i][j] == 'F') {
                        count += 1;
                    }
                } else if(flag == -1 && j % 2 == 0) {
                    if(board[i][j] == 'F') {
                        count += 1;
                    }
                }
            }

            flag *= -1;
        }

        bw.write(count + "");
        bw.flush();
    }
}