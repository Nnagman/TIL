package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 순위검색 {

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210",
            "python frontend senior chicken 150", "cpp backend senior pizza 260",
            "java backend junior chicken 80", "python backend senior chicken 50"};

        String[] query = {"java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150", "- and - and - and chicken 100",
            "- and - and - and - 150"};
        System.out.println(Arrays.toString(solution(info, query)));
    }

    static HashMap<String, ArrayList<Integer>> hs;

    static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        hs = new HashMap<>();
        String[] sArr;
        int score;

        for (String s : info) {
            sArr = s.split(" ");
            score = Integer.parseInt(sArr[4]);
            dfs(0, new String[4], sArr, score);
        }

        for (String key : hs.keySet()) {
            Collections.sort(hs.get(key));
        }

        int idx = 0;

        for (String q : query) {
            sArr = q.split(" and | ");
            String key = sArr[0] + sArr[1] + sArr[2] + sArr[3];
            if (!hs.containsKey(key)) {
                answer[idx++] = 0;
                continue;
            }
            ArrayList<Integer> list = hs.get(key);
            score = Integer.parseInt(sArr[4]);
            answer[idx++] = list.size() - binary(list, score);
        }

        return answer;
    }

    static void dfs(int depth, String[] sArr, String[] infoArr, int score) {
        if (depth == 4) {
            String s = String.join("", sArr);
            if (!hs.containsKey(s)) {
                hs.put(s, new ArrayList<>());
            }
            hs.get(s).add(score);
            return;
        }
        sArr[depth] = infoArr[depth];
        dfs(depth + 1, sArr, infoArr, score);
        sArr[depth] = "-";
        dfs(depth + 1, sArr, infoArr, score);
    }

    static int binary(ArrayList<Integer> list, int n) {
        int mid;
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            mid = (left + right) / 2;

            if (list.get(mid) < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
