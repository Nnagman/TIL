package skillTest.level2.binaryTransformation;

import java.util.Arrays;
import java.util.Objects;

public class BinaryTransformation {
    public static void main(String[] args) {
        String s = "110010101001";

        System.out.println(Arrays.toString(solution(s)));
    }

    public static int[] solution(String s) {
        int[] answer = {0, 0};

        while (!Objects.equals(s, "1")) {
            answer[0] += 1;
            String t = s.replaceAll("0", "");
            answer[1] += s.length() - t.length();
            s = Integer.toBinaryString(t.length());
        }

        return answer;
    }
}
