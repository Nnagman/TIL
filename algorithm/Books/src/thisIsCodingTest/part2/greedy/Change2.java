package thisIsCodingTest.part2.greedy;

import java.util.Scanner;

public class Change2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        int[] coins = {500, 100, 50, 10};
        int count = 0;

        for (int coin : coins) {
            count += money / coin;
            money %= coin;
        }

        System.out.println(count);
    }
}
