package thisIsCodingTest.part3.greedy.amountThatCantMake;


import java.util.Arrays;

public class AmountThatCantMake {
    public static int solution(int n, int[] data) {
        Arrays.sort(data);
        int now;
        int max_value = 1;

        for (int i : data) {
            now = i;
            if (max_value < now) break;
            max_value += now;
        }

        return max_value;
    }
}

