package 단기간성장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 탈옥 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Prisoner implements Comparable<Prisoner> {
        int x, y, cnt;

        Prisoner(int x, int y) {
            this.x = x;
            this.y = y;
            this.cnt = 0;
        }

        Prisoner(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Prisoner o) {
            return Integer.compare(this.cnt, o.cnt);
        }
    }

    static int[][] bfs(char[][] map, Prisoner prisoner, int h, int w) {
        PriorityQueue<Prisoner> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[h + 2][w + 2];
        int[][] history = new int[h + 2][w + 2];

        pq.add(prisoner);
        visited[prisoner.x][prisoner.y] = true;

        while (!pq.isEmpty()) {
            Prisoner temp = pq.poll();
            history[temp.x][temp.y] = temp.cnt;

            for (int i = 0; i < 4; i++) {
                int nx, ny;
                nx = temp.x + dx[i];
                ny = temp.y + dy[i];
                if (0 <= nx && 0 <= ny && nx < h + 2 && ny < w + 2 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pq.add(new Prisoner(nx, ny, map[nx][ny] == '#' ?
                            temp.cnt + 1 : temp.cnt));
                }
            }
        }
        return history;
    }

    static int getMinimum(int[][] one, int[][] two, int[][] sg, char[][] map) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < one.length; i++) {
            for (int j = 0; j < one[0].length; j++) {
                if (map[i][j] == '*') continue;
                int sum = one[i][j] + two[i][j] + sg[i][j];
                if (map[i][j] == '#') sum -= 2;
                min = Math.min(min, sum);
            }
        }

        return min;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            char[][] map = new char[h + 2][w + 2];
            Prisoner[] prisoners = new Prisoner[2];
            int idx = 0;

            for (int j = 0; j < h; j++) {
                String str = br.readLine();
                for (int k = 0; k < w; k++) {
                    map[j + 1][k + 1] = str.charAt(j);
                    if (str.charAt(j) == '$')
                        prisoners[idx++] = new Prisoner(j + 1, k + 1);
                }
            }

            int[][] one = bfs(map, prisoners[0], h, w);
            int[][] two = bfs(map, prisoners[1], h, w);
            int[][] sg = bfs(map, new Prisoner(0, 0), h, w);

            result[i] = getMinimum(one, two, sg, map);
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
