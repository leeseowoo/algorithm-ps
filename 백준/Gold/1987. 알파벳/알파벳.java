import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int global;
    static char[][] board;
    static int r, c;
    static Set<Character> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        board = new char[r][c];

        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            for(int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 0);

        bw.write(global + "");
        bw.flush();
    }

    static void dfs(int x, int y, int local) {
        if(x < 0 || y < 0 || x >= r || y >= c) {
            return;
        }

        if(set.contains(board[x][y])) {
            global = Math.max(global, local);
            return;
        }

        set.add(board[x][y]);
        local++;

        dfs(x - 1, y, local);   // 상
        dfs(x + 1, y, local);   // 하
        dfs(x, y - 1, local);   // 좌
        dfs(x, y + 1, local);   // 우

        set.remove(board[x][y]);
    }
}