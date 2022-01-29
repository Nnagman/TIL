package thisIsCodingTest.part2.greedy;

import java.util.Scanner;

public class UntilReachOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int ans = 0;

        while (true) {
            int target = n % k;
            ans += target;
            n = n - target;
            if (n < k) break;
            ans += 1;
            n /= k;
        }

        ans += (n - 1);
        System.out.println(ans);
    }
}
