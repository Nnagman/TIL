package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지 {

    static class Node implements Comparable<Node> {

        int x, y, coin;

        public Node(int x, int y, int coin) {
            this.x = x;
            this.y = y;
            this.coin = coin;
        }

        @Override
        public int compareTo(Node o) {
            return this.coin - o.coin;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int problem_count = 1;
        StringTokenizer st;
        int[][] map;
        int[][] cost_map;
        boolean[][] visited;
        PriorityQueue<Node> pq;
        Node node;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            map = new int[n][n];
            cost_map = new int[n][n];
            visited = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost_map[i][j] = Integer.MAX_VALUE / 4;
                }
            }

            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            pq = new PriorityQueue<>();

            pq.offer(new Node(0, 0, map[0][0]));
            cost_map[0][0] = map[0][0];
            visited[0][0] = true;

            while (!pq.isEmpty()) {
                node = pq.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = node.x + dx[i];
                    int ny = node.y + dy[i];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n
                        || cost_map[nx][ny] < cost_map[node.x][node.y] + map[nx][ny]
                        || visited[nx][ny]) {
                        continue;
                    }

                    cost_map[nx][ny] = cost_map[node.x][node.y] + map[nx][ny];
                    pq.offer(new Node(nx, ny, cost_map[nx][ny]));
                    visited[nx][ny] = true;
                }
            }

            sb.append("Problem ").append(problem_count++).append(": ")
                .append(cost_map[n - 1][n - 1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
