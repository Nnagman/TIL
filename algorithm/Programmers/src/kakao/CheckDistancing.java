package kakao;

import java.util.Arrays;

public class CheckDistancing {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(
                new String[][]{
                        {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}
        )));
    }

    static public int[] solution(String[][] places) {
        int[] answer = {};

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {

                }
            }
        }

        return answer;
    }

    static private boolean checkDistancing(String[] room, int x, int y) {
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
            }
        }

        return true;
    }
}
