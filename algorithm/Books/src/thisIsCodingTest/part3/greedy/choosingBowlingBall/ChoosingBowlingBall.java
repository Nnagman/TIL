package thisIsCodingTest.part3.greedy.choosingBowlingBall;

public class ChoosingBowlingBall {
    public static int Solution(int n, int m, int[] data) {
        int[] counts = new int[11];
        int result = 0;

        for (int i : data) {
            counts[i] += 1;
        }

        for (int i = 1; i < m + 1; i++) {
            if (counts[i] > 0) {
                n -= counts[i];
                result += counts[i] * n;
            }
        }

        return result;
    }
}
