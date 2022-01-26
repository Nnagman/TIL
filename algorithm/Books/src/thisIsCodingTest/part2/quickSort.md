
```
public static void quick_sort(int start, int end, int[] arr) {
        if (start >= end) return;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= arr[start]) {
                left++;
            }

            while (start < right && arr[start] <= arr[right]) {
                right--;
            }

            if (right < left) {
                int temp = arr[start];
                arr[start] = arr[right];
                arr[right] = temp;
            } else {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }

        quick_sort(start, right - 1, arr);
        quick_sort(right + 1, end, arr);
    }
```