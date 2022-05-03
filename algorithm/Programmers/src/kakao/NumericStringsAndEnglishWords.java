package kakao;

import java.util.HashMap;
import java.util.Map;

public class NumericStringsAndEnglishWords {
    public static void main(String[] args) {
        System.out.println(solution("23four5six7"));
    }

    public static int solution(String s) {

        String[] arr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(arr[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}
