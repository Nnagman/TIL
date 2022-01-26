package practice.hash.camouflage;

import java.util.HashMap;
import java.util.Arrays;

import static java.util.stream.Collectors.*;

public class Camouflage {
    public static void main(String[] ars) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
        System.out.println(solution2(clothes));
    }

    static public int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (String[] s : clothes)
            map.put(s[1], map.containsKey(s[1]) ? map.get(s[1]) + 1 : 1);

        for (String key : map.keySet())
            answer = answer > 0 ? answer * (map.get(key) + 1) : map.get(key) + 1;

        return answer - 1;
    }

    static public int solution2(String[][] clothes) {
        return Arrays.stream(clothes)
                .collect(groupingBy(p -> p[1], mapping(p -> p[0], counting())))
                .values()
                .stream().reduce(1L, (x, y) -> x * (y + 1)).intValue() - 1;
    }
}
