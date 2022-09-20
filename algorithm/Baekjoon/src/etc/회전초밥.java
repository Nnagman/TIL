package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 회전초밥 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int ans = 0;
        int left = 0;
        int right = 0;
        int cnt = 0;
        HashSet<Integer> hashSet = new HashSet<>();

        while (true) {
            if (left == n) {
                break;
            }

            if (cnt == k) {
                cnt = 0;
                left += 1;
                right = left;
                hashSet.add(c);
                ans = Math.max(ans, hashSet.size());
                if (ans == k + 1) {
                    break;
                }
                hashSet = new HashSet<>();
                continue;
            }

            cnt += 1;
            hashSet.add(arr[right]);
            right = right == n - 1 ? 0 : right + 1;
        }

        System.out.println(ans);
    }
}
