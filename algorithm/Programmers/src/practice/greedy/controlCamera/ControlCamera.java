package practice.greedy.controlCamera;

import java.util.Arrays;
import java.util.Comparator;

public class ControlCamera {
    public static void main(String[] args) {
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};

        System.out.println(solution(routes));
    }

    public static int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int answer = 0;
        int sector = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (sector < route[0]) {
                ++answer;
                sector = route[1];
            }
        }
        return answer;
    }
}
