```
    public static void dynamicProgrammingTopDown(int n, int[] d, int count) {
        if (d[n] < count && d[n] != 0) return;
        else d[n] = count;

        if (n == 1) {
            answer = Math.min(count, answer);
            return;
        }

        if (n % 5 == 0) dynamicProgrammingTopDown(n / 5, d, count + 1);
        if (n % 3 == 0) dynamicProgrammingTopDown(n / 3, d, count + 1);
        if (n % 2 == 0) dynamicProgrammingTopDown(n / 2, d, count + 1);
        dynamicProgrammingTopDown(n - 1, d, count + 1);
    }

    public static int dynamicProgrammingBottomUp(int n) {
        int[] d = new int[n + 1];

        for (int i = 2; i < n + 1; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }

        return d[n];
    }
```