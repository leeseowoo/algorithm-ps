import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = sc.nextInt();
        int[] stack = new int[n];
        int size = 0;

        while (n-- > 0) {
            String command = sc.next();

            switch (command) {
                case "push":
                    int number = Integer.parseInt(sc.next());
                    stack[size++] = number;
                    break;

                case "pop":
                    if (size == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack[size - 1] + "\n");
                        size -= 1;
                    }
                    break;

                case "size":
                    bw.write(size + "\n");
                    break;

                case "empty":
                    if (size == 0) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;

                case "top":
                    if (size == 0) {
                        bw.write("-1\n");
                    } else {
                        bw.write(stack[size - 1] + "\n");
                    }
                    break;
            }
        }

        bw.flush();
    }
}