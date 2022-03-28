package thisIsCodingTest.part2.dfsBfs;

public class DeepFirstSearch {
    private static void dfs(int[][] graph, boolean[] visited, int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i : graph[v]) {
            if (!visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    public static void main(String[] args) {
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
        boolean[] visited = new boolean[graph.length];

        dfs(graph, visited, 1);
    }
}
