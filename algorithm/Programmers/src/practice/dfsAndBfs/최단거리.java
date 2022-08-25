package practice.dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;

public class 최단거리 {

    public static void main(String[] args) {
        int[][] arr1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}}; // 11
        int[][] arr2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0},
            {0, 0, 0, 0, 1}}; // -1
        System.out.println(solution(arr1));
    }

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int x, y, nx, ny;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        maps[0][0] = 1;
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            x = now[0];
            y = now[1];

            if (x == n - 1 && y == m - 1) {
                return maps[x][y];
            }

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || maps[nx][ny] != 1
                    || visited[nx][ny]) {
                    continue;
                }

                q.add(new int[]{nx, ny});
                maps[nx][ny] = maps[x][y] + 1;
                visited[nx][ny] = true;
            }
        }
        return -1;
    }
}
