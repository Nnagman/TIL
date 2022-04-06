package thisIsCodingTest.part2.binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindingParts2 {
    static private void binarySearch(int start, int end, int target, int[] arr) {
        while (true) {
            int mid = (start + end) / 2;
            if (end <= start) {
                System.out.print("no ");
                break;
            } else if (arr[mid] == target) {
                System.out.print("yes ");
                break;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    static private void countSort(int[] parts, int[] targetArr) {
        int max = parts[parts.length - 1];
        int[] arr = new int[max + 1];

        for (int i : parts) {
            arr[i] += 1;
        }

        for (int i : targetArr) {
            if (arr[i] < 1) {
                System.out.print("no ");
            } else {
                System.out.print("yes ");
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] partArr = new int[n];
        Map<Integer, Integer> partMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            partArr[i] = temp;
            partMap.put(temp, temp);
        }

        int m = sc.nextInt();
        int[] findArr = new int[m];

        for (int i = 0; i < m; i++) {
            findArr[i] = sc.nextInt();
        }

        Arrays.sort(partArr);
        Arrays.sort(findArr);

        for (int i : findArr) {
            binarySearch(0, n, i, partArr);
        }
        System.out.println();
        countSort(partArr, findArr);
        System.out.println();
        for (int i : findArr) {
            if (partMap.containsKey(i)) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
