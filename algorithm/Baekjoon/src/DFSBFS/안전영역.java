package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전영역 {

    static int N, ta, nx, ny, ans = 0, max = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i][j], max);
            }
        }

        for (int i = 0; i < max; i++) {
            visited = new boolean[N][N];
            ta = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (!visited[j][k] && arr[j][k] > i) {
                        ta += 1;
                        dfs(j, k, i);
                    }
                }
            }
            System.out.println(i + " " + ta);
            ans = Math.max(ta, ans);
        }
        System.out.println(ans);
    }

    static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] <= h || visited[nx][ny]) {
                continue;
            }
            dfs(nx, ny, h);
        }
    }
}
