```
int total, mid, answer = 0;
        int start = 0;
        int end = cakes[n - 1];
        int len = cakes.length;

        while (start <= end) {
            total = 0;
            mid = (start + end) / 2;

            for (int i = len - 1; 0 < i; i--) {
                if (cakes[i] > mid) {
                    total += cakes[i] - mid;
                } else {
                    break;
                }
            }

            if (total < m) {
                end = mid - 1;
            } else {
                answer = mid;
                start = mid + 1;
            }
        }
```