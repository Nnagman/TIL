package practice.sorting.theBiggestNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TheBiggestNumber {
    public static void main(String[] args) {
        int[] numbers = {23, 232, 21, 212};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        List<Integer> list = Arrays.stream(numbers).boxed().sorted(
                (o1, o2) -> {
                    String t1 = o1.toString();
                    String t2 = o2.toString();
                    return (t2 + t1).compareTo(t1 + t2);
                }).collect(Collectors.toList());

        String answer = "";

        for (Integer num : list) answer = answer.concat(Integer.toString(num));

        if (answer.charAt(0) == '0') answer = "0";

        return answer;
    }
}
