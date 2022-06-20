import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        boolean[][] visitedA = new boolean[n][n];
        boolean[][] visitedB = new boolean[n][n];
        int[][] areaCount = new int[2][3];      // 0: R, 1: G, 2: B
        int countA = 0, countB = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedA[i][j]) {          // 적록색약이 아닌 사람이 봤을 때
                    char currentArea = map[i][j];
                    bfs(currentArea, 'A', i, j, map, visitedA, n);
                    if (currentArea == 'R') {
                        areaCount[0][0]++;
                    } else if (currentArea == 'G') {
                        areaCount[0][1]++;
                    } else {
                        areaCount[0][2]++;
                    }
                }

                if (!visitedB[i][j]) {          // 적록색약인 사람이 봤을 때
                    char currentArea = map[i][j];
                    bfs(currentArea, 'B', i, j, map, visitedB, n);
                    if (currentArea == 'R' || currentArea == 'G') {
                        areaCount[1][0]++;
                    } else {
                        areaCount[1][2]++;
                    }
                }
            }
        }

        for (int i = 0; i <= 2; i++) {
            countA += areaCount[0][i];
            countB += areaCount[1][i];
        }

        bw.write(countA + " " + countB);
        bw.flush();
    }

    static void bfs(char area, char type, int startX, int startY, char[][] map, boolean[][] visited, int n) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i <= 3; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (area == map[nx][ny]) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }

                if (type == 'B' && (area == 'R' || area == 'G') && (map[nx][ny] == 'R' || map[nx][ny] == 'G')) {
                    q.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}