package practice.dfsAndBfs;

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

    static public int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        return answer;
    }
}
