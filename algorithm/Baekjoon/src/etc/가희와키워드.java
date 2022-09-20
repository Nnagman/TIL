package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 가희와키워드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hashSet.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < m; i++) {
            if (hashSet.isEmpty()) {
                sb.append(0).append("\n");
                continue;
            }
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreElements()) {
                hashSet.remove(st.nextToken());
            }
            sb.append(hashSet.size()).append("\n");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
