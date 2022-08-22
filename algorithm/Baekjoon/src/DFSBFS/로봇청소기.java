package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로봇청소기 {

    static int N, M, r, c, d, nx, ny, ans = 0;
    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {-1, 0, 1, 0};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);
        System.out.println(ans);
    }

    static void dfs(int x, int y, int di) {
        if (arr[nx][ny] == 0) {
            arr[nx][ny] = 2;
            ans += 1;
        }

        for (int i = 0; i < 4; i++) {
            di = (d + 3) % 4;
            nx = x + dx[di];
            ny = y + dy[di];

            if (nx > -1 && ny > -1 && nx < N && ny < M && arr[nx][ny] == 0) {
                dfs(nx, ny, di);
                return;
            }
        }

        di = (di + 2) % 4;
        nx = x + dx[di];
        ny = y + dy[di];

        if (nx > -1 && ny > -1 && nx < N && ny < M && arr[nx][ny] != 1) {
            dfs(nx, ny, di);
        }
    }
}
