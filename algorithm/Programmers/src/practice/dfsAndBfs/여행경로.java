package practice.dfsAndBfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 여행경로 {

    public static void main(String[] args) {
        String[][][] arr = {
            {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}},
            {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}},
            {{"ICN", "JFK"}, {"ICN", "JFK"}, {"IAD", "ICN"}, {"HND", "IAD"}, {"JFK", "HND"}},
            {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}},
            {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"},
                {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}}
        };

        for (String[][] strings : arr) {
            System.out.println(Arrays.toString(solution(strings)));
        }
    }

    static List<String> list;
    static boolean[] used;

    static String[] solution(String[][] tickets) {

        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));

        list = new ArrayList<>();

        used = new boolean[tickets.length];

        dfs(tickets, "ICN", "ICN", 0);

        Collections.sort(list);

        return list.get(0).split(" ");
    }

    private static void dfs(String[][] tickets, String ans, String start, int cnt) {
        if (cnt == tickets.length) {
            list.add(ans);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(start)) {
                used[i] = true;
                dfs(tickets, ans + " " + tickets[i][1], tickets[i][1], cnt + 1);
                used[i] = false;
            }
        }
    }
}
