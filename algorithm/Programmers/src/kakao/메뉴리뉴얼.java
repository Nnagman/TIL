package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class 메뉴리뉴얼 {

    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(solution(orders, course)));
    }

    static HashMap<String, Integer> hs = new HashMap<>();

    static String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        int[] count = new int[21];

        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

        for (int len : course) {
            for (String order : orders) {
                StringBuilder sb = new StringBuilder();
                if (len <= order.length()) {
                    getCombination(order, sb, 0, 0, len);
                }
            }
        }

        for (Entry<String, Integer> entry : hs.entrySet()) {
            if (entry.getValue() < 2) {
                continue;
            }
            int len = entry.getKey().length();
            count[len] = Math.max(count[len], entry.getValue());
        }

        for (Entry<String, Integer> entry : hs.entrySet()) {
            int len = entry.getKey().length();
            if (count[len] < 2 || entry.getValue() < count[len]) {
                continue;
            }
            list.add(entry.getKey());
        }

        Collections.sort(list);

        return list.toArray(new String[0]);
    }

    static void getCombination(String s, StringBuilder sb, int idx, int cnt, int n) {
        if (cnt == n) {
            hs.put(sb.toString(), hs.getOrDefault(sb.toString(), 0) + 1);
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));
            getCombination(s, sb, i + 1, cnt + 1, n);
            sb.delete(cnt, cnt + 1);
        }
    }
}
