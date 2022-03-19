package thisIsCodingTest.part2.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamDecision {
    private static int n, m;
    private static int[] parent = new int[100001];

    private static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= m; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int oper = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (oper != 1) {
                unionParent(a, b);
            } else {
                if (findParent(a) != findParent(b)) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}
