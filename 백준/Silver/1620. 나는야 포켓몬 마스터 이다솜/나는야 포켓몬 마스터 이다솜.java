import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());   // 도감에 수록된 포켓몬 수
        int m = Integer.parseInt(st.nextToken());   // 문제 수

        Map<String, String> nameMap = new HashMap<>();
        Map<String, String> numberMap = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String name = br.readLine();
            nameMap.put(name, String.valueOf(i));
            numberMap.put(String.valueOf(i), name);
        }

        for(int i = 1; i <= m; i++) {
            String input = br.readLine();
            if (nameMap.containsKey(input)) {
                bw.write(nameMap.get(input) + "\n");
            } else {
                bw.write(numberMap.get(input) + "\n");
            }
        }

        bw.flush();
    }
}