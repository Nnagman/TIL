package thisIsCodingTest.part2.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LawOfBigNumber2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println((m - m % k) * arr[0] + m % k * arr[1]);
    }
}
