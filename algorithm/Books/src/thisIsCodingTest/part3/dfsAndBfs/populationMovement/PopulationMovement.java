package thisIsCodingTest.part3.dfsAndBfs.populationMovement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class PopulationMovement {
    private static int n, l, r;
    private static int totalCount = 0;

    public static int[][] graph = new int[50][50];
    public static int[][] unions = new int[50][50];

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    private static void process(int x, int y, int index) {
        ArrayList<Position> united = new ArrayList<>();
        united.add(new Position(x, y));

        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));
        unions[x][y] = index;
        int summary = graph[x][y];
        int count = 1;

        while (!q.isEmpty()) {
            Position pos = q.poll();
            x = pos.getX();
            y = pos.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < n && unions[nx][ny] == -1) {
                    int gap = Math.abs(graph[nx][ny] - graph[n][y]);
                    if (l <= gap && gap <= r) {
                        q.offer(new Position(nx, ny));
                        unions[nx][ny] = index;
                        summary += graph[nx][ny];
                        count += 1;
                        united.add(new Position(nx, ny));
                    }
                }
            }
        }

        for (Position position : united) {
            x = position.getX();
            y = position.getY();
            graph[x][y] = summary / count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        l = sc.nextInt();
        r = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        while (true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    unions[i][j] = -1;
                }
            }
            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (unions[i][j] == -1) {
                        process(i, j, index);
                        index += 1;
                    }
                }
            }
            if (index == n * n) break;
            totalCount += 1;
        }

        System.out.println(totalCount);
    }
}
