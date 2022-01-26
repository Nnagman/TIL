package practice.sorting.hIndex;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import java.util.TreeMap;

public class HIndex {
    public static void main(String[] args) {
        int[] citations = {4, 1};
        System.out.println(solution2(citations));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        int count = 0;
        int max = 0;

        TreeMap<Integer, Integer> tm = new TreeMap<>(Collections.reverseOrder());

        for (int citation : citations)
            tm.put(citation, tm.getOrDefault(citation, 0) + 1);

        Optional<Integer> tmpKey = tm.keySet().stream().findFirst();
        if (tmpKey.isPresent()) max = tmpKey.get();

        for (int i = max; i > -1; i--) {
            if (tm.containsKey(i)) count = tm.get(i) + count;
            if (count > i - 1 && i > answer) answer = i;
        }

        return answer;
    }

    public static int solution2(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int smaller = Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, smaller);
        }
        return answer;
    }
}