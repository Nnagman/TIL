package practice.dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;

public class 아이템줍기 {

    public static void main(String[] args) {
        int[][][] rectangles = {
            {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}},
            {{1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}},
            {{1, 1, 5, 7}},
            {{2, 1, 7, 5}, {6, 4, 10, 10}},
            {{2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}},
            {{1, 1, 3, 3}, {2, 2, 4, 4}}
        };
        int[] characterX = {1, 9, 1, 3, 1, 1};
        int[] characterY = {3, 7, 1, 1, 4, 1};
        int[] itemX = {7, 6, 4, 7, 6, 4};
        int[] itemY = {8, 1, 7, 10, 3, 4};

        for (int i = 0; i < rectangles.length; i++) {
            System.out.println(
                solution(rectangles[i], characterX[i], characterY[i], itemX[i], itemY[i]));
        }
    }

    static private class Node {

        int x, y, cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static public int solution(int[][] rectangle, int characterX, int characterY, int itemX,
        int itemY) {
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        int[][] map = new int[102][102];
        int answer = 0;
        int x1;
        int x2;
        int y1;
        int y2;

        for (int[] value : rectangle) {
            x1 = value[0] * 2;
            y1 = value[1] * 2;
            x2 = value[2] * 2;
            y2 = value[3] * 2;
            for (int j = x1; j < x2 + 1; j++) {
                for (int k = y1; k < y2 + 1; k++) {
                    map[j][k] = 1;
                }
            }
        }

        for (int[] value : rectangle) {
            x1 = value[0] * 2;
            y1 = value[1] * 2;
            x2 = value[2] * 2;
            y2 = value[3] * 2;
            for (int j = x1 + 1; j < x2; j++) {
                for (int k = y1 + 1; k < y2; k++) {
                    map[j][k] = 0;
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int nx, ny;
        boolean[][] visited = new boolean[102][102];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(characterX, characterY, 0));
        visited[characterX][characterY] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == itemX && node.y == itemY) {
                answer = node.cnt / 2;
                break;
            }

            for (int i = 0; i < 4; i++) {
                nx = node.x + dx[i];
                ny = node.y + dy[i];
                if (nx < 1 || ny < 1 || nx > 100 || ny > 100 || visited[nx][ny]
                    || map[nx][ny] == 0) {
                    continue;
                }

                q.add(new Node(nx, ny, node.cnt + 1));
                visited[nx][ny] = true;
            }
        }

        return answer;
    }
}
