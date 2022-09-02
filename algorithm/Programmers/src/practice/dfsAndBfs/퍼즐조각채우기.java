package practice.dfsAndBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 퍼즐조각채우기 {

    public static void main(String[] args) {
        int[][][] boards = {{
            {1, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 1},
            {1, 0, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 0}
        }};
        int[][][] tables = {{
            {1, 0, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 1},
            {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0}
        }};

        for (int i = 0; i < boards.length; i++) {
            System.out.println(solution(boards[i], tables[i]));
        }
    }

    static class Shape {

        boolean used;
        int count;
        int[][] shape;

        public Shape(boolean used, int count, int[][] shape) {
            this.used = used;
            this.count = count;
            this.shape = shape;
        }
    }

    static public int solution(int[][] game_board, int[][] table) {
        int nx, ny, nc;
        int answer = 0;
        int len = game_board.length;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        List<Shape> tableList = new ArrayList<>();
        List<Shape> boardList = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (table[i][j] == 1) {
                    int[][] temp = new int[12][12];
                    q.add(new int[]{i, j});
                    table[i][j] = 0;
                    nc = 1;
                    temp[5][5] = 1;

                    while (!q.isEmpty()) {
                        int[] dot = q.poll();

                        for (int k = 0; k < 4; k++) {
                            nx = dot[1] + dx[k];
                            ny = dot[0] + dy[k];

                            if (nx < 0 || ny < 0 || nx >= len || ny >= len || table[ny][nx] == 0) {
                                continue;
                            }

                            q.add(new int[]{nx, ny});
                            temp[5 + dot[0] - ny][5 + dot[1] - nx] = 1;
                            table[nx][ny] = 0;
                            nc += 1;
                        }
                    }
                    tableList.add(new Shape(false, nc, temp));
                }
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (game_board[i][j] == 0) {
                    int[][] temp = new int[12][12];
                    q.add(new int[]{i, j});
                    game_board[i][j] = 0;
                    nc = 1;
                    temp[5][5] = 1;

                    while (!q.isEmpty()) {
                        int[] dot = q.poll();

                        for (int k = 0; k < 4; k++) {
                            nx = dot[1] + dx[k];
                            ny = dot[0] + dy[k];

                            if (nx < 0 || ny < 0 || nx >= len || ny >= len
                                || game_board[ny][nx] == 0) {
                                continue;
                            }

                            q.add(new int[]{nx, ny});
                            temp[5 + dot[0] - ny][5 + dot[1] - nx] = 1;
                            table[nx][ny] = 0;
                            nc += 1;
                        }
                    }
                    boardList.add(new Shape(false, nc, temp));
                }
            }
        }

        while (!boardList.isEmpty()) {
            Shape shape = boardList.get(0);
            int temp = -1;

            for (int i = 0; i < tableList.size(); i++) {
                int[][] temp1 = shape.shape;
                int[][] temp2 = tableList.get(i).shape;

                if (checkSame(temp1, temp2, shape.count)) {
                    answer += shape.count;
                    boardList.remove(0);
                    temp = i;
                    break;
                }
            }

            if (temp > -1) {
                tableList.remove(temp);
            }
        }

        return answer;
    }

    static private boolean checkSame(int[][] board, int[][] table, int count) {
        int temp = 0;
        int len = board.length;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (table[i][j] == 1 && board[i][j] == 1 && table[i][j] == board[i][j]) {
                    temp += 1;
                }
            }
        }

        if (temp == count) {
            return true;
        }

        int[][] rotate = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                rotate[len - i - 1][j] = table[i][j];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int t = rotate[i][j];
                rotate[i][j] = rotate[j][i];
                rotate[j][i] = t;
            }
        }

        temp = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (table[i][j] == 1 && rotate[i][j] == 1 && table[i][j] == rotate[i][j]) {
                    temp += 1;
                }
            }
        }

        return temp == count;
    }
}