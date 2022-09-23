package kakao;

public class 파괴되지않은건물 {

    public static void main(String[] args) {
        System.out.println(
            solution(
                new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}},
                new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2},
                    {1, 0, 1, 3, 3, 1}}
            )
        );
    }

    static int[][] arr;

    static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int type, r1, c1, r2, c2, degree;
        arr = new int[board.length + 1][board[0].length + 1];

        for (int[] s : skill) {
            type = s[0] == 1 ? -1 : 1;
            r1 = s[1];
            c1 = s[2];
            r2 = s[3];
            c2 = s[4];
            degree = s[5];
            arr[r1][c1] += degree * type;
            arr[r1][c2 + 1] += -degree * type;
            arr[r2 + 1][c1] += -degree * type;
            arr[r2 + 1][c2 + 1] += degree * type;
        }

        for (int i = 0; i < arr[0].length; i++) {
            columnCumulativeSum(i);
        }

        for (int i = 0; i < arr.length; i++) {
            rowCumulativeSum(i);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += arr[i][j];
                if (board[i][j] > 0) {
                    answer += 1;
                }
            }
        }

        return answer;
    }

    static void columnCumulativeSum(int c) {
        int cnt = arr[0][c];
        for (int i = 1; i < arr.length; i++) {
            arr[i][c] += cnt;
            cnt = arr[i][c];
        }
    }

    static void rowCumulativeSum(int r) {
        int cnt = arr[r][0];
        for (int i = 1; i < arr[0].length; i++) {
            arr[r][i] += cnt;
            cnt = arr[r][i];
        }
    }
}
