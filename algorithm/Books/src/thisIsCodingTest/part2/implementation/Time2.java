package thisIsCodingTest.part2.implementation;

import java.util.Scanner;

public class Time2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (k % 10 == 3 || k / 10 == 3 || j % 10 == 3 || j / 10 == 3 || i % 10 == 3 || i / 10 == 3)
                        count++;
                }
            }
        }

        System.out.println(count);
    }
}
