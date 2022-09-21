package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 합승택시요금 {

    public static void main(String[] args) {
        System.out.println(solution(6, 4, 6, 2,
            new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2},
                {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
                {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
    }

    static class Node implements Comparable<Node> {

        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int solution(int n, int s, int a, int b, int[][] fares) {
        int ans = Integer.MAX_VALUE;

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < fares.length; i++) {
            graph.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }

        for (int i = 1; i < n + 1; i++) {
            int[] dist = new int[n + 1];
            boolean[] visited = new boolean[n + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<Node> q = new PriorityQueue<>();
            q.add(new Node(i, 0));
            dist[i] = 0;

            while (!q.isEmpty()) {
                Node node = q.poll();

                if (visited[node.to]) {
                    continue;
                }

                visited[node.to] = true;

                for (Node temp : graph.get(node.to)) {
                    if (dist[temp.to] > node.cost + temp.cost) {
                        q.add(new Node(temp.to, node.cost + temp.cost));
                        dist[temp.to] = node.cost + temp.cost;
                    }
                }
            }

            ans = Math.min(dist[a] + dist[b] + dist[s], ans);
        }

        return ans;
    }
}
