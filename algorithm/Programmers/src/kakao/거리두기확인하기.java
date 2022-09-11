package kakao;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        System.out.println(Arrays.toString(solution(places)));
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            boolean isDistancing = true;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (places[i][j].charAt(k) == 'P') {
                        if (!checkDistance(places[i], j, k)) {
                            isDistancing = false;
                            break;
                        }
                    }
                }
            }
            answer[i] = isDistancing ? 1 : 0;
        }

        return answer;
    }

    static boolean checkDistance(String[] places, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int cnt = arr[2] + 1;
            if (cnt == 3) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || places[nx].charAt(ny) == 'X' ||
                    visited[nx][ny]) {
                    continue;
                }
                if (places[nx].charAt(ny) == 'P' && cnt < 3) {
                    return false;
                }
                queue.add(new int[]{nx, ny, cnt});
                visited[nx][ny] = true;
            }
        }

        return true;
    }
}
