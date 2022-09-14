package kakao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 수식최대화 {

    public static void main(String[] args) {
        System.out.println(solution("200-300-500-600*40+500+500"));
    }

    static String[] arr = {"*", "+", "-"};

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
                    HashMap<String, Integer> hs = new HashMap<>();
                    hs.put(arr[i], 0);
                    hs.put(arr[j], 1);
                    hs.put(arr[k], 2);
                    answer = Math.max(answer, getResult(expression, hs));
                }
            }
        }

        return answer;
    }

    static long getResult(String expression, HashMap<String, Integer> hs) {
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        String temp = "";

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                temp += c;
            } else {
                queue.add(temp);
                temp = "";
                while (!stack.isEmpty()
                    && hs.get(String.valueOf(c)) >= hs.get(stack.peek())) {
                    queue.add(stack.pop());
                }
                stack.push(String.valueOf(c));
            }
        }

        queue.add(temp);

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        Stack<Long> stack2 = new Stack<>();
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.equals("+") || temp.equals("-") || temp.equals("*")) {
                long n1 = stack2.pop();
                long n2 = stack2.pop();
                if (temp.equals("+")) {
                    stack2.push(n2 + n1);
                } else if (temp.equals("-")) {
                    stack2.push(n2 - n1);
                } else {
                    stack2.push(n2 * n1);
                }
                continue;
            }
            stack2.push(Long.parseLong(temp));
        }
        return Math.abs(stack2.pop());
    }
}
