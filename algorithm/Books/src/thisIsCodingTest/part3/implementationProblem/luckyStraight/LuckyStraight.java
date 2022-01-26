package thisIsCodingTest.part3.implementationProblem.luckyStraight;

public class LuckyStraight {
    public static String Solution(int n) {
        String s = Integer.toString(n);
        int len = s.length() / 2;
        int sum = 0;

        String left = s.substring(0, len);
        String right = s.substring(len);

        for (int i = 0; i < len; i++) {
            sum += left.charAt(i);
            sum -= right.charAt(i);
        }

        return sum == 0 ? "LUCKY" : "READY";
    }
}
