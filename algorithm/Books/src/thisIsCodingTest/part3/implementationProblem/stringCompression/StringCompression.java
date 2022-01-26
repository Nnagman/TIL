package thisIsCodingTest.part3.implementationProblem.stringCompression;

public class StringCompression {
    public static int solution(String s) {
        int answer = s.length();
        int step_len = s.length() / 2 + 1;
        int len = s.length();
        int count;

        StringBuilder compressed = new StringBuilder();
        String prev;

        for (int i = 1; i < step_len; i++) {
            compressed = new StringBuilder();
            prev = s.substring(0, i);
            count = 1;
            for (int j = i; j < len; j += i) {
                if (prev.equals(s.substring(j, Math.min(j + i, len)))) {
                    count += 1;
                } else {
                    compressed.append(count >= 2 ? count + prev : prev);
                    prev = s.substring(j, Math.min(j + i, len));
                    count = 1;
                }
            }
            compressed.append(count >= 2 ? count + prev : prev);
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("ababcdcdababcdcd"));
    }
}
