package practice.dfsAndBfs;

public class 네트워크 {

    public static void main(String[] args) {
        int[] n = {3, 3, 4};
        int[][] arr1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] arr2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int[][] arr3 = {{1, 1, 0, 0}, {1, 1, 0, 1}, {0, 0, 1, 0}, {0, 1, 0, 1}};
        System.out.println(solution(n[2], arr3));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(computers, visited, i);
                answer += 1;
            }
        }

        return answer;
    }

    public static void dfs(int[][] arr, boolean[] visited, int i) {
        int n = arr.length;
        visited[i] = true;

        for (int j = 0; j < n; j++) {
            if (arr[i][j] != 0 && !visited[j]) {
                dfs(arr, visited, j);
            }
        }
    }
}
