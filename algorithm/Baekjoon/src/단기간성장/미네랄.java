package 단기간성장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미네랄 {
    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C;
    static char[][] map;
    static int[][] cluster;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j];
            }
        }

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int shot = Integer.parseInt(st.nextToken());
            remove(shot, i % 2);
            set();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void remove(int h, int d) {
        if (d != 1) {
            for (int i = 0; i < C; i++) {
                if (map[R - h][i] != '.') {
                    map[R - h][i] = '.';
                    return;
                }
            }
        } else {
            for (int i = C - 1; i >= 0; i--) {
                if (map[R - h][i] != '.') {
                    map[R - h][i] = '.';
                    return;
                }
            }
        }
    }

    static void set() {
        cluster = new int[R][C];

        int n = 1;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'x' && cluster[i][j] == 0) {
                    if (find(i, j, n)) return;
                    n++;
                }
            }
        }
    }

    static boolean find(int x, int y, int n) {
        int low = -1;
        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> list = new ArrayList<>();

        q.add(new Node(x, y));
        cluster[x][y] = n;

        while (!q.isEmpty()) {
            Node now = q.poll();
            low = Math.max(low, now.x);

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C)
                    continue;

                if (cluster[nx][ny] == 0 && map[nx][ny] == 'x') {
                    cluster[nx][ny] = n;
                    q.add(new Node(nx, ny));
                }
            }
            list.add(now);
        }
        if (low != R - 1) {
            move(list);
            return true;
        }
        return false;
    }

    static void move(ArrayList<Node> list) {
        int move = 1;

        for (Node node : list) {
            map[node.x][node.y] = '.';
        }

        outerLoop:
        while (true) {
            for (Node node : list) {
                if (node.x + move == R || map[node.x + move][node.y] == 'x') {
                    move--;
                    break outerLoop;
                }
            }
            move++;
        }

        for (Node node : list) {
            map[node.x + move][node.y] = 'x';
        }
    }
}
