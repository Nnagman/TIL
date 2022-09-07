package kakao;

import java.util.Stack;

public class 괄호변환 {

    public static void main(String[] args) {
        String[] p = {
            "(()())()",
            ")(",
            "()))((()"
        };
        for (String s : p) {
            System.out.println(solution(s));
        }
    }

    static private String solution(String p) {
        String answer = "";

        return answer;
    }

    static private String recursive(String p) {
        int vStart, pLen = p.length();
        String temp;

        for (int i = pLen; i > 0; i--) {
            temp = p.substring(0, i + 1);
            if (checkBalanced(temp)) {
                if (checkRight(temp)) {
                    if (i == pLen) {
                        return temp;
                    }
                    return temp + recursive(p.substring(i));
                }
                vStart = i;
                break;
            }
        }

        temp = "(" + recursive(p.substring(vStart)) + ")";

        return temp;
    }

    static private Boolean checkRight(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                if (c != stack.peek()) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    static private Boolean checkBalanced(String p) {
        int cnt = 0;
        for (char c : p.toCharArray()) {
            if (c == '(') {
                cnt += 1;
            } else {
                cnt -= 1;
            }
        }
        return cnt == 0;
    }
}
