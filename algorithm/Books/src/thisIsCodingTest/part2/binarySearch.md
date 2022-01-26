##
```
public static int binary_search_recursive(int start, int end, int target, int[] arr) {
        if (start > end) return -1;

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return binary_search_recursive(start, mid - 1, target, arr);
        } else {
            return binary_search_recursive(mid + 1, end, target, arr);
        }
    }

    public static int binary_search_loop(int start, int end, int target, int[] arr) {
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
```