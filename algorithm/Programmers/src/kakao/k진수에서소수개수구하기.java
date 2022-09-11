package kakao;

public class k진수에서소수개수구하기 {

    public static void main(String[] args) {
        System.out.println(solution(524287, 2));
    }

    static int solution(int n, int k) {
        int answer = 0;
        String num = "";

        while (n > k) {
            num = (n % k) + num;
            n = n / k;
        }

        num = n + num;
        String[] arr = num.split("0");

        for (String s : arr) {
            if (s.equals("1") || s.isBlank() || s.isEmpty()) {
                continue;
            }
            answer += isPrime(Long.parseLong(s)) ? 1 : 0;
        }

        return answer;
    }

    static boolean isPrime(Long n) {
        for (int i = 2; i < (long) Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
