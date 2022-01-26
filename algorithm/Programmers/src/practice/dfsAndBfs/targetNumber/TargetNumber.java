package practice.dfsAndBfs.targetNumber;

public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 1, 2};
        int target = 2;
        System.out.println(solution(numbers, target));
    }

    public static int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    /**
     * 동적계획법 참고 https://ko.wikipedia.org/wiki/%EB%8F%99%EC%A0%81_%EA%B3%84%ED%9A%8D%EB%B2%95
     */
    public static int dfs(int[] numbers, int n, int sum, int target) {
        if (n == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        return dfs(numbers, n + 1, sum + numbers[n], target) + dfs(numbers, n + 1, sum - numbers[n], target);
    }
}
