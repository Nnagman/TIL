package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 알파벳 {

    static HashSet<String> hashSet = new HashSet<>();
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static String[][] arr;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new String[r][c];

        for (int i = 0; i < r; i++) {
            arr[i] = br.readLine().split("");
        }

        hashSet.add(arr[0][0]);
        dfs(0, 0, r, c, 1);

        System.out.println(ans);
    }

    static void dfs(int x, int y, int r, int c, int cnt) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c || hashSet.contains(arr[nx][ny])) {
                continue;
            }
            hashSet.add(arr[nx][ny]);
            dfs(nx, ny, r, c, cnt + 1);
            hashSet.remove(arr[nx][ny]);
        }

        ans = Math.max(ans, cnt);
    }
}
