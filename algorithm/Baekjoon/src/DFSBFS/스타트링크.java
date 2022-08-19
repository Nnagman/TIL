package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크 {

    static int F, S, G, U, D, x, nx;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 전체층
        F = Integer.parseInt(st.nextToken());
        // 지금층
        S = Integer.parseInt(st.nextToken());
        // 가야할층
        G = Integer.parseInt(st.nextToken());
        // 올라갈수있는층수
        U = Integer.parseInt(st.nextToken());
        // 내려갈수있는층수
        D = -Integer.parseInt(st.nextToken());

        if (S < G && U == 0) {
            System.out.println("use the stairs");
            return;
        }

        if (S > G && D == 0) {
            System.out.println("use the stairs");
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        visited = new boolean[F + 1];
        arr = new int[F + 1];
        visited[S] = true;
        arr[S] = 0;
        q.add(S);

        while (!q.isEmpty()) {
            x = q.poll();

            if (x == G) {
                System.out.println(arr[x]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    nx = x + U;
                }
                if (i == 1) {
                    nx = x + D;
                }

                if (nx > F || nx < 1) {
                    continue;
                }

                if (!visited[nx]) {
                    arr[nx] = arr[x] + 1;
                    visited[nx] = true;
                    q.add(nx);
                }
            }
        }

        System.out.println("use the stairs");
    }
}
