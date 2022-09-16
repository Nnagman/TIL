package kakao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 후보키 {

    public static void main(String[] args) {
        String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"},
            {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"},
            {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
        System.out.println(solution(relation));
    }

    static List<String> candidates = new ArrayList<>();

    static int solution(String[][] relation) {
        for (int i = 0; i < relation[0].length; i++) {
            dfs(new boolean[relation[0].length], 0, 0, i + 1, relation);
        }

        return candidates.size();
    }

    static void dfs(boolean[] visited, int start, int depth, int end, String[][] relation) {
        if (depth == end) {
            List<Integer> list = new ArrayList<>();
            String key = "";

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    key += String.valueOf(i);
                    list.add(i);
                }
            }

            HashSet<String> hashSet = new HashSet<>();

            for (int i = 0; i < relation.length; i++) {
                String s = "";
                for (Integer j : list) {
                    s += relation[i][j];
                }
                if (hashSet.contains(s)) {
                    return;
                }
                hashSet.add(s);
            }

            for (String s : candidates) {
                int cnt = 0;
                for (int i = 0; i < key.length(); i++) {
                    if (s.contains(String.valueOf(key.charAt(i)))) {
                        cnt += 1;
                    }
                }
                if (cnt == s.length()) {
                    return;
                }
            }

            candidates.add(key);
            return;
        }

        for (int i = start; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            dfs(visited, i, depth + 1, end, relation);
            visited[i] = false;
        }
    }
}
