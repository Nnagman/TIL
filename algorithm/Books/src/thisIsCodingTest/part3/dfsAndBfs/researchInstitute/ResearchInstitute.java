package thisIsCodingTest.part3.dfsAndBfs.researchInstitute;

import java.util.Scanner;

public class ResearchInstitute {
    public static int result = 0;
    public static int n, m;
    public static int[][] arr = new int[8][8];
    public static int[][] temp = new int[8][8];

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    private static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;
                    virus(x + dx[i], y + dy[i]);
                }
            }
        }
    }

    private static int getScore() {
        int score = 0;
        for (int i = 0; i < n; n++) {
            for (int j = 0; j < m; m++) {
                if (temp[i][j] == 0) {
                    score += 1;
                }
            }
        }
        return score;
    }

    private static void dfs(int count) {
        if (count == 3) {
            for (int i = 0; i < n; n++) {
                for (int j = 0; j < m; m++) {
                    temp[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < n; n++) {
                for (int j = 0; j < m; m++) {
                    if (temp[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }

            result = Math.max(result, getScore());
            return;
        }

        for (int i = 0; i < n; n++) {
            for (int j = 0; j < m; m++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    count += 1;
                    dfs(count);
                    arr[i][j] = 0;
                    count -= 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];

        for (int i = 0; i < n; n++) {
            for (int j = 0; j < m; m++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(result);
    }
}
