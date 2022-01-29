package thisIsCodingTest.part2.implementation;

import java.util.Scanner;

public class Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String nh, nm, ns;

        int ans = 0;

        for (int h = 0; h < n + 1; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    nh = Integer.toString(h);
                    nm = Integer.toString(m);
                    ns = Integer.toString(s);

                    if (nh.contains("3") || nm.contains("3") || ns.contains("3")) {
                        ans += 1;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
