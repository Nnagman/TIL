package thisIsCodingTest.part2.implementation;

import java.util.Scanner;

public class GameDevelopment {
    public static int n, m, x, y, direction;
    public static int[][] d = new int[50][50];
    public static int[][] arr = new int[50][50];

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int cnt = 1;
        int turnTime = 0;

        while (true) {
            turn_left();
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (d[nx][ny] == 0 && arr[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = nx;
                cnt += 1;
                turnTime = 0;
                continue;
            } else {
                turnTime += 1;
            }

            if (turnTime == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];

                if (arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
                turnTime = 0;
            }
        }

        System.out.println(cnt);
    }
}
