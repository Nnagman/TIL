package thisIsCodingTest.part2.greedy;

import java.util.Scanner;

public class NumberCardGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int temp = 100001;
            for (int j = 0; j < m; j++) {
                temp = Math.min(temp, sc.nextInt());
            }
            ans = Math.max(temp, ans);
        }

        System.out.println(ans);
    }
}
