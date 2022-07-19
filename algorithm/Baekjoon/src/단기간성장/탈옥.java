package 단기간성장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 탈옥 {
    static int t, h, w;
    static int result = Integer.MAX_VALUE;

    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static Deque<Node> sg = new ArrayDeque<>();
    static Deque<Node> one = new ArrayDeque<>();
    static Deque<Node> two = new ArrayDeque<>();

    static int[][] distArr;

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] bfs(Deque<Node> q) {
        int d[][] = new int[h + 2][w + 2];
        visited = new boolean[h + 2][w + 2];

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.x][node.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < h + 2 && ny < w + 2)
                    if (map[nx][ny] == '*') continue;

                if (!visited[nx][ny]) {
                    if (map[nx][ny] == '#') {
                        d[nx][ny] = d[node.x][node.y] + 1;
                        visited[nx][ny] = true;
                        q.addLast(new Node(nx, ny));
                    }
                } else {
                    visited[nx][ny] = true;
                    d[nx][ny] = d[node.x][node.y];
                    q.addFirst(new Node(nx, ny));
                }
            }
        }
        return d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            result = Integer.MAX_VALUE;
            sg.clear();
            one.clear();
            two.clear();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h + 2][w + 2];
            distArr = new int[h + 2][w + 2];
            boolean flag = false;

            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    map[i][j] = '.';
                }
            }

            for (int i = 1; i < h; i++) {
                String line = br.readLine();
                for (int j = 1; j < w; j++) {
                    map[i][j] = line.charAt(j - 1);
                    if (!flag && map[i][j] == '$') {
                        one.add(new Node(i, j));
                        flag = true;
                    } else if (flag && map[i][j] == '$') {
                        two.add(new Node(i, j));
                    }
                }
            }

            sg.add(new Node(0, 0));
            int[][] sgArr = bfs(sg);
            int[][] oneArr = bfs(one);
            int[][] twoArr = bfs(two);

            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    distArr[i][j] = sgArr[i][j] + oneArr[i][j] + twoArr[i][j];
                }
            }

            for (int i = 0; i < h + 2; i++) {
                for (int j = 0; j < w + 2; j++) {
                    if (map[i][j] == '*') continue;
                    if (map[i][j] == '#') distArr[i][j] -= 2;
                    result = Math.min(result, distArr[i][j]);
                }
            }
            System.out.println(result);
        }
    }
}
