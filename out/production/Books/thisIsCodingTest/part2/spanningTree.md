1. 신장트리(SpanningTree)는 하나의 그래프가 있을 때 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프다.
2. Kruskal 알고리즘은 각각의 노드를 최소한의 비용으로 연결하여 신장트리를 만들고 싶을 때 쓰는 대표적인 알고리즘이다.
3. Kruskal 알고리즘은 간선 데이터가 주어졌을 때 오름차순으로 정렬한 뒤, Union-Find 알고리즘을 활용하여 사이클이 발생 하지 않는지 확인하며 연결하면 된다.
4. Union-find 알고리즘은 disjointState(서로소집합)에서 확인하자.

```
    public static int kruskal(int[][] list, int v) {
        int answer = 0;
        int[] parent = new int[v + 1];

        Arrays.sort(list, Comparator.comparingInt(o -> o[2]));

        for (int i = 0; i < v + 1; i++) {
            parent[i] = i;
        }

        // item[0]은 노드 a, item[1]은 노드 b, item[2]은 간선 비용이다.
        for (int[] item : list) {
            if (findParent(parent, item[0]) != findParent(parent, item[1])) {
                unionParent(parent, item[0], item[1]);
                answer += item[2];
            }
        }

        return answer;
    }
    
    public static int findParent(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = findParent(parent, parent[x]);
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = findParent(parent, a);
        b = findParent(parent, b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }
```