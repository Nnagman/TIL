package thisIsCodingTest.part2.dynamicProgramming;

import java.util.Scanner;

public class AntWarrior2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 3; i < n; i++) {
            arr[i] = Math.max(arr[i] + arr[i - 2], arr[i] + arr[i - 3]);
        }

        System.out.println(Math.max(arr[n - 1], arr[n - 2]));
    }
}
