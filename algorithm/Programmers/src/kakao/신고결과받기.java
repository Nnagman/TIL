package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 신고결과받기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(
                    new String[]{"muzi", "frodo", "apeach", "neo"},
                    new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                    2)
            )
        );
    }

    static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> hs = new HashMap<>();
        Map<String, List<String>> hs2 = new HashMap<>();

        for (String id : id_list) {
            hs.put(id, 0);
            hs2.put(id, new ArrayList<>());
        }

        for (String str : report) {
            String[] t = str.split(" ");
            if (!hs2.get(t[0]).contains(t[1])) {
                hs.put(t[1], hs.get(t[1]) + 1);
                hs2.get(t[0]).add(t[1]);
            }
        }

        int idx = 0;

        for (String id : id_list) {
            List<String> list = hs2.get(id);
            for (String str : list) {
                if (hs.get(str) > k - 1) {
                    answer[idx] += 1;
                }
            }
            idx += 1;
        }

        return answer;
    }
}
