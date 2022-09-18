package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static class Node {

        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N;
    static int M;
    static int ans = Integer.MAX_VALUE;
    static int[][] arr;
    static int[][] arr2;

    static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(x, y, 1));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int nc = node.cnt + 1;

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;

                if (nx == N && ny == M) {
                    ans = Math.min(nc, ans);
                }

                if (nx != 0 && ny != 0 && nx != N + 1 && ny != M + 1 && arr2[nx][ny] == 1) {
                    arr2[nx][ny] = 0;
                    q.add(new Node(nx, ny, nc));
                    x = nx;
                    y = ny;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i + 1][j + 1] = Character.getNumericValue(line[j]);
            }
        }

        arr2 = new int[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                arr2[i][j] = arr[i][j];
            }
        }

        bfs(1, 1);

        System.out.println(ans);
    }
}
