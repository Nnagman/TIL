package thisIsCodingTest.part3.binarySearch.countingNumber;

import java.util.Scanner;

public class CountingNumber {
    private static int lowerBound(int[] arr, int target, int start, int end) {
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    private static int upperBound(int[] arr, int target, int start, int end) {
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    private static int countingRange(int[] arr, int leftValue, int rightValue) {
        int rightIndex = upperBound(arr, rightValue, 0, arr.length);
        int leftIndex = lowerBound(arr, leftValue, 0, arr.length);

        return rightIndex - leftIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer x = sc.nextInt();

        int count = -1;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        count = countingRange(arr, x, x);

        System.out.println(count == 0 ? -1 : count);
    }
}
