package kakao;

import java.util.Arrays;

public class HighestAndLowestLottoRanking {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        solution(
                                new int[]{44, 1, 0, 0, 31, 25},
                                new int[]{31, 10, 45, 1, 6, 19}
                        ))
        );
    }

    static public int[] solution(int[] lottos, int[] win_nums) {
        int highest = 0;
        int lowest = 0;

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                highest++;
                continue;
            }

            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    highest++;
                    lowest++;
                }
            }
        }

        highest = highest == 0 ? 6 : 7 - highest;
        lowest = lowest == 0 ? 6 : 7 - lowest;

        return new int[]{highest, lowest};
    }
}
