package PackFATPrep;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] quiz = new char[11][9];
        char[] anskey = { 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A', 'A' };
        int[] correct = new int[11];

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 9; j++) {
                quiz[i][j] = scanner.next().charAt(0);
                if (quiz[i][j] == anskey[j]) {
                    correct[i]++;
                }
            }
        }

        for (int i = 0; i < correct.length; i++) {
            System.out.println("Student " + i + "has " + correct[i] + "answers correct!");
        }

        scanner.close();
    }
}
