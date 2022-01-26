package practice.dfsAndBfs.network;

/**
 * 참고: https://www.pymoon.com/entry/Programmers-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-DFS-%ED%92%80%EC%9D%B4-Java
 */
public class Network {
    public static void main(String[] args) {
        int n = 4;
        int[][] computers = {{1, 1, 0, 0}, {1, 1, 0, 1}, {0, 0, 1, 0}, {0, 1, 0, 1}};

        System.out.println(getAnswer(n, computers));
    }

    public static int getAnswer(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer += dfs(i, computers, visited);
            }
        }
        return answer;
    }

    public static int dfs(int i, int[][] computers, boolean[] visited) {
        if (visited[i]) {
            return 0;
        }
        visited[i] = true;
        for (int j = 0; j < computers[i].length; j++) {
            if (computers[i][j] == 1) {
                dfs(j, computers, visited);
            }
        }
        return 1;
    }
}
