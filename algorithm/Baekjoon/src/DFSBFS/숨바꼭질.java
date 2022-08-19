package DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {

    static int N, K, x, nx;
    static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        arr[N] = 1;

        while (!q.isEmpty()) {
            x = q.poll();

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nx = x + 1;
                } else if (i == 1) {
                    nx = x - 1;
                } else {
                    nx = x * 2;
                }

                if (nx == K) {
                    System.out.println(arr[x]);
                    return;
                }

                if (nx >= 0 && nx < 100001 && arr[nx] == 0) {
                    q.add(nx);
                    arr[nx] = arr[x] + 1;
                }
            }
        }
    }
}
