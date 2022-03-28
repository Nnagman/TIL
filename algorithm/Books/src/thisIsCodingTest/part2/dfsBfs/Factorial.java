package thisIsCodingTest.part2.dfsBfs;

import java.util.Arrays;
import java.util.Scanner;

public class Factorial {
    static private int iterativeFactorial(int n) {
        if (n <= 1) return 1;
        int result = 1;
        for (int i = 1; i < n + 1; i++) {
            result *= i;
        }
        return result;
    }

    static private int recursiveFactorial(int n) {
        if (n <= 1) return 1;
        return n * recursiveFactorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(iterativeFactorial(n));
        System.out.println(recursiveFactorial(n));
    }
}
