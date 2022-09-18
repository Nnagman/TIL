package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        arr[n] = 0;

        while (!q.isEmpty()) {
            int t = q.poll();

            if (t == k || t < 0 || t > 100000) {
                continue;
            }

            if (t * 2 < 100001 && arr[t * 2] > arr[t]) {
                arr[t * 2] = arr[t];
                q.add(t * 2);
            }

            if (t + 1 < 100001 && arr[t + 1] > arr[t] + 1) {
                arr[t + 1] = arr[t] + 1;
                q.add(t + 1);
            }

            if (t - 1 > -1 && arr[t - 1] > arr[t] + 1) {
                arr[t - 1] = arr[t] + 1;
                q.add(t - 1);
            }
        }

        System.out.println(arr[k]);
    }
}
