package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int right = 0;
        int left = 0;
        int len = Integer.MAX_VALUE;
        int sum = 0;

        while (left <= n && right <= n) {
            if (sum < s) {
                sum += arr[right++];
            } else {
                len = Math.min(len, right - left);
                sum -= arr[left++];
            }
        }

        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}
