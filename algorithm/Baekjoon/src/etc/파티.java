package etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 파티 {

    static class Node {

        int now, time;

        public Node(int now, int time) {
            this.now = now;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int a, b, c;
        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> reverse_graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverse_graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            reverse_graph.get(b).add(new Node(a, c));
        }

        int[] dist = new int[n];
        int[] reverse_dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(reverse_dist, Integer.MAX_VALUE);

        dijstra(graph, dist, x, n);
        dijstra(reverse_graph, reverse_dist, x, n);

        int ans = -1;

        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, dist[i] + reverse_dist[i]);
        }

        System.out.println(ans);
    }

    static void dijstra(List<List<Node>> graph, int[] dist, int start, int n) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.time)));
        pq.offer(new Node(start, 0));

        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.now]) {
                continue;
            }

            visited[node.now] = true;

            for (Node t : graph.get(node.now)) {
                if (dist[t.now] > dist[node.now] + t.time) {
                    dist[t.now] = dist[node.now] + t.time;
                    pq.add(new Node(t.now, dist[t.now]));
                }
            }
        }
    }
}
