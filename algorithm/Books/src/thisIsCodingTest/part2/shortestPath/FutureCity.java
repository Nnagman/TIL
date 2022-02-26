package thisIsCodingTest.part2.shortestPath;

import java.util.Arrays;
import java.util.Scanner;

public class FutureCity {
    public static int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드 수(n), 간선 수(m), 거쳐 갈 노드(k), 최종 목적지 노드(x)
    public static int m, n, x, k;
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (i == j) graph[i][j] = 0;
            }
        }

        // 각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        for (int i = 0; i < m; i++) {
            // A와 B가 서로에게 가는 비용은 1이다.
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        x = sc.nextInt();
        k = sc.nextInt();

        // 점화식에 따라 플로이드 워셜 알고리즘을 수행
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int distance = graph[1][k] + graph[k][x];

        if (distance >= INF) System.out.println(-1);
        else System.out.println(distance);
    }
}
