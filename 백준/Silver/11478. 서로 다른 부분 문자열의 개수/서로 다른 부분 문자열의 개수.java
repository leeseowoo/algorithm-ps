import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> set = new HashSet<>();
        String str = br.readLine();
        int length = str.length();

        for (int i = 0; i < length; i++) {
            StringBuilder part = new StringBuilder();
            part.append(str.charAt(i));
            set.add(String.valueOf(part));
            for (int j = i + 1; j < length; j++) {
                part.append(str.charAt(j));
                set.add(String.valueOf(part));
            }
        }

        bw.write(set.size() + "");
        bw.flush();
    }
}