package thisIsCodingTest.part2.greedy;

import java.util.Scanner;

public class NumberCardGame2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int max = 0;
        int temp;

        for (int i = 0; i < n; i++) {
            temp = 10001;
            for (int j = 0; j < m; j++) {
                temp = Math.min(temp, sc.nextInt());
            }
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}
