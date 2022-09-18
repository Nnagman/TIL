package dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS와BFS {

    static int N, M, V;
    static int[][] arr;
    static boolean[] visited;
    static int a, b, temp;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 정점 개수
        N = Integer.parseInt(st.nextToken());
        // 간선 개수
        M = Integer.parseInt(st.nextToken());
        // 시작 정점
        V = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        visited = new boolean[N + 1];
        dfs(V);

        System.out.println();

        visited = new boolean[N + 1];
        bfs();
    }

    static void dfs(int n) {
        System.out.print(n + " ");
        visited[n] = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[n][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        sb = new StringBuilder();

        q.add(V);
        visited[V] = true;
        sb.append(V).append(" ");

        while (!q.isEmpty()) {
            temp = q.poll();
            for (int i = 0; i < arr.length; i++) {
                if (arr[temp][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }

        System.out.println(sb);
    }
}
