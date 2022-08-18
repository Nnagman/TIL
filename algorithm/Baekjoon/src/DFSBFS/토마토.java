package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    static class Node {

        int x, y, z, cnt;

        public Node(int x, int y, int z, int cnt) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.cnt = cnt;
        }
    }

    static int M, N, H, a, b, c;
    static int[][][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[] dz = {1, -1};
    static int cnt = 0;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        arr = new int[N][M][H];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    a = Integer.parseInt(st.nextToken());
                    if (a == 0) {
                        cnt += 1;
                    }
                    if (a == 1) {
                        q.offer(new Node(j, k, i, 0));
                    }
                    arr[j][k][i] = a;
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                a = node.x + dx[i];
                b = node.y + dy[i];
                c = node.z;
                if (a >= 0 && b >= 0 && a < N && b < M && arr[a][b][c] == 0) {
                    q.offer(new Node(a, b, c, node.cnt + 1));
                    cnt -= 1;
                    arr[a][b][c] = 1;
                    ans = node.cnt + 1;
                }
            }

            for (int i = 0; i < 2; i++) {
                a = node.x;
                b = node.y;
                c = node.z + dz[i];
                if (c >= 0 && c < H && arr[a][b][c] == 0) {
                    q.offer(new Node(a, b, c, node.cnt + 1));
                    cnt -= 1;
                    arr[a][b][c] = 1;
                    ans = node.cnt + 1;
                }
            }
        }

        System.out.println(cnt == 0 ? ans : -1);
    }
}
