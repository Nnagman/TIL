package thisIsCodingTest.part3.dfsAndBfs.parenthesisTransformation;

public class ParenthesisTransformation {
    private static int balancedIndex(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count += 1;
            else count -= 1;
            if (count == 0) return i;
        }
        return -1;
    }

    private static boolean checkProper(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') count += 1;
            else {
                if (count == 0) return false;
                count -= 1;
            }
        }
        return true;
    }

    private static String solution(String p) {
        String answer = "";
        if (p.equals("")) return answer;
        int index = balancedIndex(p);
        String u = p.substring(0, index + 1);
        String v = p.substring(index + 1);

        if (checkProper(u)) {
            answer = u + solution(v);
        } else {
            answer = "(" + solution(v) + ")";
            u = u.substring(1, u.length() - 1);
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') temp.append(")");
                else temp.append("(");
            }
            answer += temp.toString();
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }
}
