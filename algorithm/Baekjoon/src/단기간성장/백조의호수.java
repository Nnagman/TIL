package 단기간성장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백조의호수 {
    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Queue<Node> water = new LinkedList<>();
        Queue<Node> q = new LinkedList<>();
        Node[] swan = new Node[2];
        boolean meet = false;
        boolean[][] visited;
        char[][] map;
        int day = 0;

        map = new char[R][C];
        visited = new boolean[R][C];

        int swanIdx = 0;
        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j];
                if (map[i][j] == 'L') {
                    swan[swanIdx++] = new Node(i, j);
                }
                if (map[i][j] != 'X') {
                    water.offer(new Node(i, j));
                }
            }
        }

        q.offer(swan[0]);
        visited[q.peek().r][q.peek().c] = true;

        while (true) {
            Queue<Node> next = new LinkedList<>();
            while (!q.isEmpty()) {
                Node now = q.poll();

                if (now.r == swan[1].r && now.c == swan[1].c) {
                    meet = true;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nr = now.r + d[i][0];
                    int nc = now.c + d[i][1];

                    if (nr >= R || nr < 0 || nc >= C || nc < 0 || visited[nr][nc])
                        continue;

                    visited[nr][nc] = true;

                    if (map[nr][nc] == 'X') {
                        next.offer(new Node(nr, nc));
                        continue;
                    }
                    q.offer(new Node(nr, nc));
                }
            }
            if (meet) break;
            q = next;

            int size = water.size();

            for (int i = 0; i < size; i++) {
                Node now = water.poll();

                for (int j = 0; j < 4; j++) {
                    int nr = now.r + d[j][0];
                    int nc = now.c + d[j][1];

                    if (nr >= R || nr < 0 || nc >= C || nc < 0)
                        continue;

                    if (map[nr][nc] == 'X') {
                        map[nr][nc] = '.';
                        water.offer(new Node(nr, nc));
                    }
                }
            }
            day++;
        }
        System.out.println(day);
    }
}
