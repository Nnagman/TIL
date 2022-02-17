package thisIsCodingTest.part2.dynamicProgramming;

import java.util.Scanner;

public class AntWarrior {
    public static int[] d = new int[100];
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }

        for (int i = 3; i < n; i++) {
            d[i] = Math.max(d[i - 3] + d[i], d[i - 2] + d[i]);
        }

        System.out.println(d[n - 1]);
    }
}
