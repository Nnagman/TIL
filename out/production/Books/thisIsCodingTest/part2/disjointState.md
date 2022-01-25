1. 서로소 집합 자료구조는 서로소 부분 집합들로 나누어진 원소들의 데이터를 처리하기 위한 자료구조다.
2. 서로소 집합 자료구조는 Union과 Find이 2개의 연산으로 조작 할 수 있다. ( 해당 연산은 Union-Find 알고리즘 이라 불린다. )
3. Union-Find를 사용하면 무방향 그래프에서 각 집합의 루트 노드를 가르키도록 만들 수 있다.
4. 이를 활용하여 무방향 그래프에서 해당 그래프의 사이클 여부도 판별 가능하다. ( 두 노드를 연결하기 전에 서로 같은 부모를 가르키는지 확인 )

```
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