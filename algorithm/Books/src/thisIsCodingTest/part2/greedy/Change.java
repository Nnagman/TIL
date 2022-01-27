package thisIsCodingTest.part2.greedy;

import java.util.Scanner;

public class Change {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        int[] coinTypes = new int[]{500, 100, 50, 10};

        for (int coin : coinTypes) {
            count += n / coin;
            n %= coin;
        }

        System.out.println(count);
    }
}
