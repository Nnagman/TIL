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

    static String solution(String p) {
        return recursive(p);
    }

    static String recursive(String p) {
        if (p.length() == 0) {
            return "";
        }

        int len = p.length();
        String temp;
        String u = "";
        String v = "";

        for (int i = 1; i < len + 1; i++) {
            temp = p.substring(0, i);
            if (checkBalanced(temp)) {
                u = temp;
                v = p.substring(i);
                break;
            }
        }

        if (checkRight(u)) {
            u += recursive(v);
            return u;
        }

        temp = "(" + recursive(v) + ")";
        u = u.substring(1, u.length() - 1);
        u = reverse(u);

        return temp + u;
    }

    static String reverse(String p) {
        char[] arr = p.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == '(' ? ')' : '(';
        }
        return String.valueOf(arr);
    }

    static boolean checkRight(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty() || stack.peek() == ')') {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    static boolean checkBalanced(String p) {
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
