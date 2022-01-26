package practice.dynamicProgramming.expressWithN;

public class ExpressWithN {
    public static int n;
    public static int target;
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        System.out.println(solution(N, number));
    }

    public static int solution(int N, int number) {
        n = N;
        target = number;
        dfs(0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static void dfs(int count, int prev) {
        if (8 < count) {
            answer = -1;
            return;
        }

        if (prev == target) {
            answer = Math.min(answer, count);
            return;
        }

        int tempN = n;
        for (int i = 0; i < 8 - count; i++) {
            int newCount = count + i + 1;
            dfs(newCount, prev + tempN);
            dfs(newCount, prev - tempN);
            dfs(newCount, prev / tempN);
            dfs(newCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }
}
