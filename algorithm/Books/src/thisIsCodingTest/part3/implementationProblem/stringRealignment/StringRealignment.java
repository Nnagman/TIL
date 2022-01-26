package thisIsCodingTest.part3.implementationProblem.stringRealignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class StringRealignment {
    public static String Solution(String s) {
        List<String> list = new ArrayList<>();
        int len = s.length();
        int sum = 0;
        boolean hasInt = false;
        String c;

        for (int i = 0; i < len; i++) {
            c = String.valueOf(s.charAt(i));
            if (s.charAt(i) > 64) {
                list.add(c);
            } else {
                hasInt = true;
                sum += Integer.parseInt(c);
            }
        }

        list.sort(Comparator.comparing(Objects::toString));

        StringBuilder sb = new StringBuilder();

        for (String i : list) {
            sb.append(i);
        }

        return sb.toString() + (hasInt ? sum : "");
    }
}
