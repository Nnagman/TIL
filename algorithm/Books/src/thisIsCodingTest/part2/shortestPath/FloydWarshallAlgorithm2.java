package thisIsCodingTest.part2.shortestPath;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class FloydWarshallAlgorithm2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() + 1;
        int m = sc.nextInt();

        int[][] graph = new int[n][n];
        for (int[] ints : graph) {
            Arrays.fill(ints, (int) 1e9);
        }

        for (int i = 0; i < m; i++) {
            graph[sc.nextInt()][sc.nextInt()] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
