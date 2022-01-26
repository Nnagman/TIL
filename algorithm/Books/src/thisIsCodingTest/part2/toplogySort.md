1. Topology Sort(위상정렬)는 방향 그래프의 모든 노드를 방향성에 거스르지 않도록 순서대로 나열하는 것이다.
2. 특정한 노드로 들어오는 간선의 개수를 Indegree(진입차수)라 부르는데, 첫번째 순서도 이 진입차수가 0인 노드부터 나열해야 한다.
3. 진입차수가 0인 노드를 큐에 담고 꺼낸 뒤 해당 노드에서 출발하는 간선을 삭제한다.
4. 위 과정을 반복하면서 더 이상 큐에 담을 노드가 없을 때 까지 반복한다.

```
    public static List<Integer> solution(int[][] list, int v) {
        int[] indegree = new int[v + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] ints : list) {
            indegree[ints[1]] += 1;
            graph.get(ints[0]).add(ints[1]);
        }

        return topologySort(indegree, graph);
    }

    public static List<Integer> topologySort(int[] indegree, List<List<Integer>> graph) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int len = indegree.length;
        int now;

        for (int i = 1; i < len; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            now = queue.poll();
            result.add(now);
            for (int i : graph.get(now)) {
                indegree[i] -= 1;
                if (indegree[i] == 0) queue.add(i);
            }
        }

        return result;
    }
```