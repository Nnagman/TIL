package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 양과늑대 {

    public static void main(String[] args) {
        System.out.println(solution(
            new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5},
                {4, 6}, {8, 9}}
        ));
    }

    static Map<Integer, List<Integer>> hs;
    static boolean[] visited;
    static int answer = 0;

    static int solution(int[] info, int[][] edges) {

        hs = new HashMap<>();
        visited = new boolean[info.length];

        for (int i = 0; i < info.length; i++) {
            hs.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            hs.get(edge[0]).add(edge[1]);
        }

        dfs(0, 0, 1, 1, info, new ArrayList<>());

        return answer;
    }

    static void dfs(int now, int wolf, int sheep, int cnt, int[] info, List<Integer> routes) {
        if (sheep == wolf || cnt == info.length) {
            answer = Math.max(answer, sheep);
            return;
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(routes);
        list.remove(Integer.valueOf(now));
        list.addAll(hs.get(now));

        for (int i : list) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            if (info[i] == 0) {
                dfs(i, wolf, sheep + 1, cnt + 1, info, list);
            } else {
                dfs(i, wolf + 1, sheep, cnt + 1, info, list);
            }

            visited[i] = false;
        }
    }
}
