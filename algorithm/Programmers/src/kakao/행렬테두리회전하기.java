package kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 행렬테두리회전하기 {

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }

    static private int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows][columns];
        int[][] map2 = new int[rows][columns];
        int cnt = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = cnt++;
                map2[i][j] = map[i][j];
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int x1, y1, x2, y2, min, dir, nx, ny;
        Queue<int[]> q;
        cnt = 0;

        for (int[] query : queries) {
            x1 = query[0] - 1;
            y1 = query[1] - 1;
            x2 = query[2] - 1;
            y2 = query[3] - 1;
            q = new LinkedList<>();
            q.add(new int[]{x1, y1});
            min = map[x1][y1];
            dir = 0;

            while (dir != 4) {
                int[] t = q.peek();
                nx = t[0] + dx[dir];
                ny = t[1] + dy[dir];
                if (nx < x1 || nx > x2 || ny < y1 || ny > y2) {
                    dir += 1;
                    continue;
                }
                q.poll();
                min = Math.min(min, map[t[0]][t[1]]);
                map2[nx][ny] = map[t[0]][t[1]];
                q.add(new int[]{nx, ny});
            }

            answer[cnt++] = min;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    map[i][j] = map2[i][j];
                }
            }
        }

        return answer;
    }
}
