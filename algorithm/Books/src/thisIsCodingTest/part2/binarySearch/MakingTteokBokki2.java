package thisIsCodingTest.part2.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class MakingTteokBokki2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int start = 0;
        int end = arr[n - 1];
        int result = 0;
        while (start <= end) {
            int total = 0;
            int mid = (start + end) / 2;
            for (int i = n - 1; i > 0; i--) {
                if (arr[i] < mid) break;
                total += arr[i] - mid;
            }
            if (total < m) {
                end = mid - 1;
            } else {
                result = mid;
                start = mid + 1;
                if (total == m) break;
            }
        }
        System.out.print(result);
    }
}
