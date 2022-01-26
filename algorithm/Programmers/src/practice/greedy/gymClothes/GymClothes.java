package practice.greedy.gymClothes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GymClothes {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 4, 10};
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        List<Integer> lostList = Arrays.stream(lost).boxed().sorted().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().sorted().collect(Collectors.toList());

        for (Integer i : lost) {
            if (reserveList.contains(i)) {
                reserveList.remove(i);
                lostList.remove(i);
                answer++;
            }
        }

        for (Integer i : lostList) {
            Integer n1 = i - 1;
            Integer n2 = i + 1;
            if (reserveList.contains(n1)) {
                reserveList.remove(n1);
                answer++;
            } else if (reserveList.contains(n2)) {
                reserveList.remove(n2);
                answer++;
            }
        }

        return answer;
    }
}
