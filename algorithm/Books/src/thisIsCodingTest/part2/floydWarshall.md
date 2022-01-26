```
    public static void floydWarshall(int n, int[][] arr) {
        int[][] graph = new int[n][n];

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                if (a == b) graph[a][b] = 0;
                else graph[a][b] = Integer.MAX_VALUE;
            }
        }

        for (int[] i : arr) {
            graph[i[0]][i[1]] = i[2];
        }

        for (int k = 0; k < n; k++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
    }
```