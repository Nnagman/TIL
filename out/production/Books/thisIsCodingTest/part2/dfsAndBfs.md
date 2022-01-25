```
    public static void adjacencyMetrics() {
        int[][] graph = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1, 0},
        };
    }

    public static void adjacencyList() {
        int[][] graph = {
                {},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}
        };
    }
    
    public static void dfsByAdjacencyList(int[][] graph, int v, boolean[] visited) {
        visited[v] = true;
        for (int i : graph[v]) {
            if (!visited[i]) {
                dfsByAdjacencyList(graph, i, visited);
            }
        }
    }

    public static void dfsByAdjacencyMetrics(int[][] graph, int v, boolean[] visited) {
        int len = graph[v].length;
        visited[v] = true;
        for (int i = 0; i < len; i++) {
            if (graph[v][i] == 1 && !visited[i]) {
                dfsByAdjacencyMetrics(graph, i, visited);
            }
        }
    }
    
    public static void bfsByAdjacencyList(int[][] graph, int start) {
        int len = graph.length;
        int v;

        boolean[] visited = new boolean[len];
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            v = queue.poll();
            for (int i : graph[v]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void bfsByAdjacencyMetrics(int[][] graph, int start) {
        int len = graph.length;
        int v;

        boolean[] visited = new boolean[len];
        visited[start] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            v = queue.poll();
            for (int i = 0; i < len; i++) {
                if (!visited[i] && graph[v][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
```