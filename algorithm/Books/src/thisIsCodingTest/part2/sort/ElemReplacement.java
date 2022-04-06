package thisIsCodingTest.part2.sort;

import java.util.Arrays;
import java.util.Scanner;

public class ElemReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0;

        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
            sum += arrA[i];
        }
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            arrB[i] = sc.nextInt();
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for (int i = 0; i < k; i++) {
            int a = arrA[i];
            int b = arrB[n - i - 1];
            if (a < b) {
                sum += b - a;
            }
        }

        System.out.println(sum);
    }
}
