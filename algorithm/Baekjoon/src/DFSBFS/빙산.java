package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산 {

    static class Node {

        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, C, H, tc, nx, ny;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        H = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                H = Math.max(H, arr[i][j]);
            }
        }

        for (int i = 1; i < H; i++) {
            C = 0;
            visited = new boolean[N][M];
            for (int j = 1; j < N - 1; j++) {
                for (int k = 1; k < M - 1; k++) {
                    if (arr[j][k] < 1 || visited[j][k]) {
                        continue;
                    }
                    visited[j][k] = true;
                    dfs(j, k);
                    C += 1;
                    if (C > 1) {
                        System.out.println(i);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx < 1 || ny < 1 || nx > N - 2 || ny > M - 2 || arr[nx][ny] < 1
                || visited[nx][ny]) {
                continue;
            }
            visited[nx][ny] = true;
            dfs(nx, ny);
        }
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
    }
}
