package kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈컬러링북 {

    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
            {1, 1, 1, 0},
            {1, 1, 1, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1}
        };
        System.out.println(Arrays.toString(solution(6, 4, picture)));
    }

    static public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int color = 0;
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[][] map = new int[m][n];

        for (int i = 0; i < m; i++) {
            System.arraycopy(picture[i], 0, map[i], 0, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                numberOfArea += 1;
                q.add(new int[]{i, j});
                color = map[i][j];
                map[i][j] = 0;
                int count = 1;
                while (!q.isEmpty()) {
                    int[] t = q.poll();
                    int nx, ny;
                    for (int k = 0; k < 4; k++) {
                        nx = t[0] + dx[k];
                        ny = t[1] + dy[k];
                        if (nx < 0 || ny < 0 || nx >= m || ny >= n || map[nx][ny] != color) {
                            continue;
                        }
                        q.add(new int[]{nx, ny});
                        map[nx][ny] = 0;
                        count += 1;
                    }
                }
                maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
