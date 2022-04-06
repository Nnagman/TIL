package thisIsCodingTest.part2.dynamicProgramming;

import java.util.Scanner;

public class EfficientMoneyStructure2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        int[] d = new int[m + 1];

        for (int i = 1; i < m + 1; i++) {
            d[i] = m + 1;
        }

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            arr[i] = temp;
            d[temp] = 1;
            sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j < m + 1; j++) {
                if (d[j - arr[i]] != m + 1)
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
            }
        }
        if (d[m] == m + 1) System.out.println(-1);
        else System.out.println(d[m]);
    }
}
