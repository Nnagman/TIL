package thisIsCodingTest.part2.shortestPath;

import java.util.*;

public class ImprovedDijkstraAlgorithm2 {
    static class Node implements Comparable<Node> {
        public int idx;
        public int distance;

        public Node(int idx, int distance) {
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i < m; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) graph.get(sc.nextInt()).add(new Node(sc.nextInt(), sc.nextInt()));

        int[] d = new int[n + 1];
        Arrays.fill(d, (int) 1e9);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.distance;
            int now = node.idx;

            if (d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).distance;
                if (cost < d[graph.get(now).get(i).idx]) {
                    d[graph.get(now).get(i).idx] = cost;
                    pq.offer(new Node(graph.get(now).get(i).idx, cost));
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            System.out.println(d[i] == (int) 1e9 ? "INFINITY" : d[i]);
        }
    }
}
