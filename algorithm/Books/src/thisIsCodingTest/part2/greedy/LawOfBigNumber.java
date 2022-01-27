package thisIsCodingTest.part2.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class LawOfBigNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int first = arr[n - 1];
        int second = arr[n - 2];

        int count = (m / (k + 1)) * k;
        count += m % (k + 1);

        int ans = 0;
        ans += count * first;
        ans += (m - count) * second;

        System.out.println(ans);
    }
}
