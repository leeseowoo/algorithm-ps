import java.io.*;
import java.util.*;

public class Main {

    static int target;
    static List<Integer> cards = new ArrayList<>();
    static int maxSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int size = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < size; i++) {
            cards.add(Integer.parseInt(st.nextToken()));
        }

        bw.write(startGame(0, 0, 3) + "");
        bw.flush();
    }

    public static int startGame(int sum, int cursor, int depth) {
        if (sum > target) {
            return -1;
        }
        if (depth == 0) {
            return sum;
        }

        for (int i = cursor; i < cards.size(); i++) {
            maxSum = Math.max(maxSum, startGame(sum + cards.get(i), i + 1, depth - 1));
        }
        return maxSum;
    }
}