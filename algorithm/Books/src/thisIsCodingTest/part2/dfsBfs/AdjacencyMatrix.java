package thisIsCodingTest.part2.dfsBfs;

import java.util.Arrays;
import java.util.Scanner;

public class AdjacencyMatrix {
    static int INF = (int) 1e9 - 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) arr[i][j] = 0;
                else arr[i][j] = INF;
            }
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == b) continue;
            arr[a - 1][b - 1] = c;
            arr[b - 1][a - 1] = c;
        }

        System.out.println(Arrays.deepToString(arr));
    }
}
