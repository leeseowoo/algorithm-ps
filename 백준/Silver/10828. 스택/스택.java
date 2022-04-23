import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack();

        while (n-- > 0) {
            StringTokenizer command = new StringTokenizer(br.readLine(), " ");

            switch (command.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(command.nextToken()));
                    break;
                case "pop":
                    bw.write(stack.pop() + "\n");
                    break;
                case "size":
                    bw.write(stack.size() + "\n");
                    break;
                case "empty":
                    bw.write(stack.isEmpty() + "\n");
                    break;
                case "top":
                    bw.write(stack.top() + "\n");
                    break;
            }
        }

        bw.flush();
    }

    static class Stack {
        int[] stack;
        int ptr;

        public Stack() {
            this.stack = new int[10000];
            this.ptr = -1;
        }

        public void push(int n) {
            this.stack[++ptr] = n;
        }

        public int pop() {
            return isEmpty() == 1 ? -1 : stack[ptr--];
        }

        public int size() {
            return ptr + 1;
        }

        public int isEmpty() {
            return ptr == -1 ? 1 : 0;
        }

        public int top() {
            return isEmpty() == 1 ? -1 : stack[ptr];
        }
    }
}