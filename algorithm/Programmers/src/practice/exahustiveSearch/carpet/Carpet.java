package practice.exahustiveSearch.carpet;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        System.out.println(Arrays.toString(solution(brown, yellow)));
        System.out.println(Arrays.toString(solution2(brown, yellow)));
    }

    static int[] solution(int brown, int yellow) {
        int[] answer = {};

        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            int remainder = yellow % i;

            if (remainder == 0) {
                int share = yellow / i;

                if ((i + 2) * (share + 2) == brown + yellow)
                    return new int[]{Math.max(i, share) + 2, Math.min(i, share) + 2};
            }
        }

        return answer;
    }

    static int[] solution2(int brown, int yellow) {
        int a = (brown + 4) / 2;
        int b = brown + yellow;
        double sqrt = Math.sqrt(a * a - 4 * b);
        return new int[]{(int) (a + sqrt) / 2, (int) (a - sqrt) / 2};
    }
}
