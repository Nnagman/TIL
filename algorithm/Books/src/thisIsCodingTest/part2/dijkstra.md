```
    public static void dijkstra(int n, int[] distance, HashMap<Integer, int[][]> graph) {
        int cost;

        PriorityQueue<int[]> heapQueue = new PriorityQueue<>();

        heapQueue.add(new int[]{0, 1});
        distance[0] = 0;

        while (!heapQueue.isEmpty()) {
            int[] node = heapQueue.poll();
            int now = node[1];
            int dist = node[0];

            if (distance[now - 1] < dist) continue;

            for (int[] i : graph.get(now)) {
                cost = i[1] + dist;

                if (cost < distance[i[0] - 1]) {
                    distance[i[0] - 1] = cost;
                    heapQueue.add(new int[]{cost, i[0]});
                }
            }
        }
    }
```