package codechallange;

import java.util.HashMap;
import java.util.Stack;

public class 괄호회전하기 {

    public static void main(String[] args) {
        System.out.println(solution("[)(]"));
    }

    static int solution(String s) {
        Stack<Character> stack;
        StringBuilder sb;

        int answer = 0;
        HashMap<Character, Character> hs = new HashMap<>();
        hs.put('{', '}');
        hs.put('(', ')');
        hs.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            stack = new Stack<>();
            sb = new StringBuilder(s);
            String temp = sb.substring(0, i);
            sb.delete(0, i);
            sb.append(temp);

            for (int j = 0; j < s.length(); j++) {
                if (stack.isEmpty()) {
                    stack.push(sb.charAt(j));
                } else {
                    char peek = stack.peek();
                    if (hs.containsKey(peek) && sb.charAt(j) == hs.get(peek)) {
                        stack.pop();
                    } else {
                        stack.push(sb.charAt(j));
                    }
                }
            }
            if (stack.isEmpty()) {
                answer += 1;
            }
        }

        return answer;
    }
}
