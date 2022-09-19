package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 좋다 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int cnt = n;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        int temp;
        int ans = 0;

        for (int i = 0; i < n - 1; i++) {
            if (cnt == 0) {
                break;
            }
            for (int j = i + 1; j < n; j++) {
                temp = nums[i] + nums[j];

                if (hm.containsKey(temp)) {
                    if (nums[i] == 0 && nums[j] == 0 && hm.get(temp) < 3) {
                        continue;
                    } else if ((nums[i] == 0 || nums[j] == 0) && hm.get(temp) < 2) {
                        continue;
                    }

                    ans += hm.get(temp);
                    cnt -= hm.get(temp);
                    hm.remove(temp);
                }
            }
        }

        System.out.println(ans);
    }
}
