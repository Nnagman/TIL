package thisIsCodingTest.part2.sort;

import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max) max = arr[i];
        }

        int[] countArr = new int[max + 1];

        for (int i : arr) {
            countArr[i]++;
        }

        for (int i = 0; i < max + 1; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                System.out.print(i + " ");
            }
        }


    }
}
