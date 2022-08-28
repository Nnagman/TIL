package practice.dfsAndBfs;

import java.util.Arrays;
import java.util.Comparator;

public class 여행경로 {

    public static void main(String[] args) {
        String[][][] arr = {
            {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}},
            {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL "}, {"ATL", "ICN"}, {"ATL", "SFO"}},
            {{"ICN", "JFK"}, {"ICN", "JFK"}, {"IAD", "ICN"}, {"HND", "IAD"}, {"JFK", "HND"}},
            {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}},
            {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"},
                {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}
        };

        for (String[][] strings : arr) {
            System.out.println(Arrays.toString(solution(strings)));
        }
    }

    static String[] solution(String[][] tickets) {
        String[] answer = {};

        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));

        return answer;
    }
}
