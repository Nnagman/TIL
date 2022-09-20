package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 하늘에서별똥별이빗발친다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<int[]> stars = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            stars.add(
                new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int ans = 0;
        for (int[] star1 : stars) {
            for (int[] star2 : stars) {
                int cnt = 0;
                for (int[] star3 : stars) {
                    if (star1[0] <= star3[0] && star3[0] <= star1[0] + l && star2[1] <= star3[1]
                        && star3[1] <= star2[1] + l) {
                        cnt += 1;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        System.out.println(k - ans);
    }
}
