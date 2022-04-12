import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                scores[i] += sc.nextInt();
            }
        }

        int numberOneChefIdx = 0;
        for (int i = 0; i < 5; i++) {
            if (scores[i] > scores[numberOneChefIdx]) {
                numberOneChefIdx = i;
            }
        }

        System.out.println((numberOneChefIdx + 1) + " " + scores[numberOneChefIdx]);
    }
}