package thisIsCodingTest.part2.dynamicProgramming;

import java.util.Scanner;

public class FloorConstruction {
    public static int[] d = new int[1000];
    public static int n;

    public static int topDown(int x) {
        if (x == 1) return 1;
        if (x == 2) return 3;

        if (d[x] != 0) return d[x];
        d[x] = topDown(x - 1) + topDown(x - 2) * 2;

        return d[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {
            d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
        }

        System.out.println(d[n]);
    }
}
