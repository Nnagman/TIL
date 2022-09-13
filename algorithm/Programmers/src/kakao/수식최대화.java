package kakao;

import java.util.LinkedList;
import java.util.Queue;

public class 수식최대화 {

    public static void main(String[] args) {
        System.out.println(solution("50*6-3*2"));
    }

    static String[] arr = {"+", "-", "*"};

    static long solution(String expression) {
        long answer = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < 3; k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    answer = Math.max(answer, getResult(expression, i, j, k));
                }
            }
        }

        return answer;
    }

    static long getResult(String expression, int a, int b, int c) {
        Queue<String> queue = new LinkedList<>();
        String temp = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < expression.length(); j++) {
                if (expression.charAt(j) == '+' || expression.charAt(j) == '*'
                    || expression.charAt(j) == '-') {
                    queue.add(temp);
                    queue.add(String.valueOf(expression.charAt(j)));
                    temp = "";
                } else {
                    temp += expression.charAt(j);
                }
            }

        }
        return 0;
    }
}
