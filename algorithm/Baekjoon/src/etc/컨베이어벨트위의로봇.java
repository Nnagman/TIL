package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n * 2];
        boolean[] robot = new boolean[n];

        for (int i = 0; i < n * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;

        while (true) {
            int cnt = 0;

            for (int i : arr) {
                if (i == 0) {
                    cnt += 1;
                }
                if (cnt >= k) {
                    cnt = -1;
                    break;
                }
            }

            if (cnt == -1) {
                break;
            }

            int t = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = t;

            for (int i = robot.length - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }

            robot[0] = false;
            robot[n - 1] = false;

            for (int i = n - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && arr[i] > 0) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    arr[i] -= 1;
                }
            }

            if (arr[0] > 0) {
                robot[0] = true;
                arr[0] -= 1;
            }

            ans += 1;
        }

        System.out.println(ans);
    }
}
