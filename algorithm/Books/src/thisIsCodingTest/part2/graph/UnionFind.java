package thisIsCodingTest.part2.graph;

import java.util.Scanner;

public class UnionFind {
    // 노드 개수(v)와 간선(Union 연산)의 개수(e)
    public static int v, e;
    public static int[] parent = new int[100001];

    // 특정 원소가 속한 집합을 찾기
    private static int findParent(int x) {
        if (x == parent[x]) return x;
        // 부모 테이블을 갱신하여 추후에 검색할 때, 바로 루트 노드를 찾을 수 있게 한다.
        return parent[x] = findParent(parent[x]);
    }

    private static int findParent2(int x) {
        System.out.println("parent[" + x + "] : " + parent[x]);
        if (x == parent[x]) return x;
        return parent[x] = findParent2(parent[x]);
    }

    // 두 원소가 속한 집합을 합치기
    private static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        // 부모를 자기 자신으로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        // union(합집합) 연산을 수행
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

//        System.out.print("부모 테이블: ");
//        for (int i = 1; i <= v; i++) {
//            System.out.print(parent[i] + " ");
//        }
//        System.out.println();
//
//        System.out.print("각 원소가 속한 집합: ");
//        for (int i = 1; i <= v; i++) {
//            System.out.print(findParent(i) + " ");
//        }

        for (int i = 1; i <= v; i++) {
            System.out.println("find " + i + "'s parent");
            System.out.println("parent: " + findParent2(i));
            System.out.println();
        }
    }
}
