package thisIsCodingTest.part2.greedy;

import java.util.Scanner;

public class UntilReachOne2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println((n / k) + (n % k));
    }
}
