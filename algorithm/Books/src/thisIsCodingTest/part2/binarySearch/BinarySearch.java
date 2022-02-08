package thisIsCodingTest.part2.binarySearch;

public class BinarySearch {
    private static int binarySearchRecursive(int[] arr, int target, int start, int end) {
        int mid = (start + end) / 2;

        if (arr[mid] == target) return mid;
        else if (arr[mid] > target) return binarySearchRecursive(arr, target, start, mid - 1);
        else return binarySearchRecursive(arr, target, mid + 1, end);
    }

    private static int binarySearchLoop(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }
}
