package thisIsCodingTest.part2.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class FindingParts {
    public static int n;
    public static int m;
    public static int[] parts;
    public static int[] recipes;

    private static boolean binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        parts = new int[n];

        for (int i = 0; i < n; i++)
            parts[i] = sc.nextInt();

        Arrays.sort(parts);

        m = sc.nextInt();
        recipes = new int[m];

        for (int i = 0; i < m; i++)
            recipes[i] = sc.nextInt();

        Arrays.sort(recipes);

        for (int recipe : recipes) {
            if (binarySearch(parts, recipe, 0, parts.length)) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
