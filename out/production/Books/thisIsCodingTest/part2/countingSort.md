```
public static int[] counting_sort(int n, int[] items) {
        int[] arr = new int[n];

        for (int item : items) {
            arr[item] = 1;
        }

        return arr;
    }
```