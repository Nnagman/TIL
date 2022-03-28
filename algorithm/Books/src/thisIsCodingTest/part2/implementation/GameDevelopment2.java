package thisIsCodingTest.part2.implementation;

import java.util.Scanner;

public class GameDevelopment2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int d = sc.nextInt();

        int[][] graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        graph[x][y] = 2;
        int nx, ny;
        int turn = 0;
        int result = 1;

        while (true) {
            d -= 1;
            if (d == -1) d = 3;
            nx = x + dx[d];
            ny = y + dy[d];
            if (graph[nx][ny] == 0) {
                graph[nx][ny] = 2;
                x = nx;
                y = ny;
                result++;
                turn =0;
            } else {
                turn++;
                if (turn == 4) {
                    nx = x - dx[d];
                    ny = y - dy[d];
                    if (graph[nx][ny] != 1) {
                        x = nx;
                        y = ny;
                    } else {
                        break;
                    }
                    turn = 0;
                }
            }
        }

        System.out.println(result);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
