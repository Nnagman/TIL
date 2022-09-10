package codechallange;

import java.util.Arrays;

public class 이진변환반복하기 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
    }

    static int zeroCount = 0;
    static int convertCount = 0;

    static int[] solution(String s) {
        recursive(s);
        return new int[]{convertCount, zeroCount};
    }

    static void recursive(String s) {
        if (s.length() == 1) {
            return;
        }

        s = removeZero(s);
        String temp = "";
        int len = s.length();

        while (len != 1) {
            if (len % 2 == 1) {
                temp = "1" + temp;
            } else {
                temp = "0" + temp;
            }
            len /= 2;
        }

        temp = "1" + temp;
        convertCount += 1;
        recursive(temp);
    }

    static String removeZero(String s) {
        StringBuilder temp = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeroCount += 1;
            } else {
                temp.append(c);
            }
        }

        return temp.toString();
    }
}
