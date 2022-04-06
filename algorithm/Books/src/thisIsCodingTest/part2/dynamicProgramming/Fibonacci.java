package thisIsCodingTest.part2.dynamicProgramming;

import java.util.Scanner;

public class Fibonacci {
    static private long[] d;

    private static long defaultFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return defaultFibonacci(n - 1) + defaultFibonacci(n - 2);
    }

    private static long memoizationFibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (d[n] != 0) return d[n];
        d[n] = memoizationFibonacci(n - 1) + memoizationFibonacci(n - 2);
        return d[n];
    }

    private static long bottomUpFibonacci(int n) {
        d[1] = 1;
        d[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new long[n + 1];
        // System.out.println(defaultFibonacci(n));
        // System.out.println(memoizationFibonacci(n));
        System.out.println(bottomUpFibonacci(n));
    }
}
