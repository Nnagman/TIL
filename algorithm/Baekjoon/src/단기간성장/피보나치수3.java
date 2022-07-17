package 단기간성장;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int S = 1000000;
        long N = Long.parseLong(bf.readLine());
        int P = S / 10 * 15;

        if (N == 1 || N == 2) {
            System.out.println(1);
            return;
        }

        long[] arr = new long[P];
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i < P; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % S;
        }

        System.out.println(arr[(int) (N % P)]);
    }
}
