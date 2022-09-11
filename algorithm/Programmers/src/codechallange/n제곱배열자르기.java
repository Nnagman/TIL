package codechallange;

import java.util.Arrays;

public class n제곱배열자르기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 2, 5)));
    }

    static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];
        int cnt = 0;

        for (long i = left; i < right + 1; i++) {
            int idx = cnt++;
            answer[idx] = (int) (Math.max(i / n, i % n) + 1);
        }

        return answer;
    }
}
