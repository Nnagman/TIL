package thisIsCodingTest.part2.sort;

import java.util.Arrays;
import java.util.Scanner;

public class TopToBottom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sc.nextLine();
        }

        for (int i = 0; i < n; i++) {
            int max = i;
            for (int j = i; j < n; j++) {
                if (arr[max] < arr[j])
                    max = j;
            }
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
