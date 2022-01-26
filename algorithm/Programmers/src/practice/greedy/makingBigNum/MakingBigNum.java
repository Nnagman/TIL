package practice.greedy.makingBigNum;

import java.util.Stack;

public class MakingBigNum {
    public static void main(String[] args) {
        String number = "654321";
        int k = 3;
        System.out.println(solution(number, k));
    }

    public static String solution(String number, int k) {
        int idx = 0;
        char max;
        StringBuilder answer = new StringBuilder();

        if (number.charAt(0) == '0') return "0";
        for (int i = 0; i < number.length() - k; i++) {
            max = '0';
            for (int j = idx; j <= k + i; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }

    public static String solution2(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
