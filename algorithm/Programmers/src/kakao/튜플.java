package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class 튜플 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }

    static int[] solution(String s) {
        s = s.replaceAll("[\\{,\\}]", " ");
        String[] arr = s.split("[ ]+");
        HashMap<String, Integer> hs = new HashMap<>();

        for (int i = 1; i < arr.length; i++) {
            hs.put(arr[i], hs.getOrDefault(arr[i], 0) + 1);
        }

        List<Entry<String, Integer>> list = new ArrayList<>(hs.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = Integer.parseInt(list.get(i).getKey());
        }

        return answer;
    }
}
