package thisIsCodingTest.part2.sort;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= arr[start]) left += 1;
            while (start < right && arr[start] <= arr[right]) right -= 1;
            if (left > right) {
                int temp = arr[start];
                arr[start] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);
        System.out.println(Arrays.toString(arr));
    }
}
