package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 촌수계산 {

    static int n, m, x, y, a, b;
    static int ans = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(x, 0);

        System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
    }

    static void dfs(int now, int cnt) {
        if (now == y) {
            ans = Math.min(cnt, ans);
            return;
        }

        for (int i = 1; i < n + 1; i++) {
            if (arr[now][i] == 1 && !visited[now]) {
                visited[now] = true;
                dfs(i, cnt + 1);
                visited[now] = false;
            }
        }
    }
}
