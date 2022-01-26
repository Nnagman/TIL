package practice.greedy.connectingIslands;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 최소신장트리(MST, Minimum Spanning Tree)를 찾는 문제
 * 사용해볼만 한 알고리즘은 Kruskal, Prim 이다.
 * 만약 트리가 1자 형태라면 Prim을 그렇지 않다면 Kruskal을 사용하는게 효과적
 * Kruskal의 시간 복잡도는 O(elog₂e) Prim의 시간 복잡도는 O(n^2)
 * 여기서 사용하는 방법은 Kruskal 알고리즘.
 * 하지만 최소 값을 가진 node를 차례로 연결하기 때문에 서로 연결될 경우 부모 node를 찾아야함.
 * 그럴땐, Union-find 알고리즘을 사용하여 해결함.
 */
public class ConnectingIslands {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(solution(n, costs));
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] node : costs) {
            int from = node[0];
            int to = node[1];
            int cost = node[2];

            int fromParent = findParent(from, parent);
            int toParent = findParent(to, parent);

            if (fromParent == toParent) continue;

            answer += cost;
            parent[toParent] = fromParent;
        }

        return answer;
    }

    public static int findParent(int idx, int[] parent) {
        if (parent[idx] == idx) return idx;
        return parent[idx] = findParent(parent[idx], parent);
    }
}
