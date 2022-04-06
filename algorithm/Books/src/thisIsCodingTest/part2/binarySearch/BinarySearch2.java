package thisIsCodingTest.part2.binarySearch;

import java.util.Scanner;

public class BinarySearch2 {
    static int idx = -1;
    static int n, m;
    static int[] arr;

    private static void binarySearch(int start, int end) {
        int mid = (start + end) / 2;
        if (arr[mid] == m) {
            idx = mid;
        } else if (arr[mid] > m) {
            binarySearch(start, mid - 1);
        } else {
            binarySearch(mid + 1, end);
        }
    }

    private static void binarySearch2(int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == m) {
                idx = mid;
                break;
            } else if (arr[mid] > m) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        binarySearch2(0, n - 1);
        System.out.print(idx == -1 ? "원소가 존재하지 않습니다." : idx + 1);
    }
}
