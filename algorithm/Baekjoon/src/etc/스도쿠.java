package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스도쿠 {

    static int[][] map = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        dfs(0,0);
    }

    static void dfs(int x, int y) {
        if (y == 9) {
            dfs(x + 1, 0);
            return;
        }

        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        if (map[x][y] == 0) {
            for (int i = 1; i < 10; i++) {
                if (check(x, y, i)) {
                    map[x][y] = i;
                    dfs(x, y + 1);
                }
            }
            map[x][y] = 0;
            return;
        }
        dfs(x, y + 1);
    }

    public static boolean check(int x, int y, int value) {

        for (int i = 0; i < 9; i++) {
            if (map[x][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (map[i][y] == value) {
                return false;
            }
        }

        int matrix_x = (x / 3) * 3;
        int matrix_y = (y / 3) * 3;

        for (int i = matrix_x; i < matrix_x + 3; i++) {
            for (int j = matrix_y; j < matrix_y + 3; j++) {
                if (map[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
