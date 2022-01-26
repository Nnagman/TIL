package practice.hash.unFinishedAthlete;

import java.util.HashMap;

public class UnFinishedAthlete {
    public static void main(String[] args) {
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};
        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        return comparison(participant, completion);
    }

    public static String comparison(String[] array_1, String[] array_2) {
        HashMap<String, Integer> hm = new HashMap<>();
        for (String element : array_1) hm.put(element, hm.getOrDefault(element, 0) + 1);
        for (String element : array_2) hm.put(element, hm.get(element) - 1);
        for (String key : hm.keySet()) {
            if (hm.get(key) > 0) {
                return key;
            }
        }
        return "";
    }
}
