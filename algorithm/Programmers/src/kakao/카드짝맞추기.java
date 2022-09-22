package kakao;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 카드짝맞추기 {

    public static void main(String[] args) {
        System.out.println(
            solution(new int[][]{{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}}, 1, 0));
    }

    static class Node {

        int x, y, move;

        public Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    static int ans = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int x = 0;
    static int y = 0;
    static HashSet<String> combs = new HashSet<>();

    static int solution(int[][] board, int r, int c) {
        HashSet<Integer> cards = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    cards.add(board[i][j]);
                }
            }
        }

        permutation(cards, "");

        for (String comb : combs) {
            x = r;
            y = c;
            int move = 0;
            int[][] tempBoard = new int[4][4];

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    tempBoard[i][j] = board[i][j];
                }
            }

            for (String card : comb.split("")) {
                move += bfs(Integer.parseInt(card), tempBoard) + 1;
                tempBoard[x][y] = 0;

                move += bfs(Integer.parseInt(card), tempBoard) + 1;
                tempBoard[x][y] = 0;
            }

            ans = Math.min(ans, move);
        }

        return ans;
    }

    static int bfs(int card, int[][] board) {
        boolean[][] visited = new boolean[4][4];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            int nx = node.x;
            int ny = node.y;
            int move = node.move;

            if (board[nx][ny] == card) {
                x = nx;
                y = ny;
                return move;
            }

            for (int i = 0; i < 4; i++) {
                nx = node.x + dx[i];
                ny = node.y + dy[i];

                if (nx < 0 || nx > 3 || ny < 0 || ny > 3 || visited[nx][ny]) {
                    continue;
                }

                q.add(new Node(nx, ny, move + 1));
                visited[nx][ny] = true;
            }

            for (int i = 0; i < 4; i++) {
                int[] pos = moveCtrl(board, i, node.x, node.y);
                nx = pos[0];
                ny = pos[1];

                if ((nx == node.x && ny == node.y) || visited[nx][ny]) {
                    continue;
                }

                q.add(new Node(nx, ny, move + 1));
                visited[nx][ny] = true;
            }
        }

        return 0;
    }

    static int[] moveCtrl(int[][] board, int dir, int x, int y) {
        x += dx[dir];
        y += dy[dir];

        while (x > -1 && x < 4 && y > -1 && y < 4) {
            if (board[x][y] != 0) {
                return new int[]{x, y};
            }

            x += dx[dir];
            y += dy[dir];
        }

        return new int[]{x - dx[dir], y - dy[dir]};
    }

    static void permutation(HashSet<Integer> cards, String comb) {
        if (comb.length() == cards.size()) {
            combs.add(comb);
            return;
        }

        for (int i : cards) {
            String card = String.valueOf(i);
            if (!comb.contains(card)) {
                permutation(cards, comb + card);
            }
        }
    }
}
