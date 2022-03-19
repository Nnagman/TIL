### 다양한 그래프 알고리즘 p.266
그래프란 노드와 노드 사이에 연결된 간선(Edge)의 정보를 가지고 있는 정보 구조를 뜻한다. 그래프를 구현 방법은 인접 행렬(Adjacency Matrix, 2차원 배열을 사용하는 방식)과 인접 리스트(Adjacency List, 리스트를 사용하는 방식)이 있다.

### [서로소 집합(union-find) 자료구조 p.268](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/graph/UnionFind.java)
1. 서로소 집합(Disjoint Sets)이란 서로 공통 원소가 없는 집합을 의미한다.
   <br><br>
2. 서로소 집합 자료구조는 서로소 부분 집합들로 나누어진 원소들의 데이터를 처리하기 위한 것이다. union과 find로 이 2개의 연산을 조작할 수 있어 union-find 자료구조라 불리기도 한다. 구현할 때는 트리 자료구조를 이용하여 집합을 표현한다.
   <br><br>
3. 알고리즘은 다음과 같다. 첫번째 단계는 union(합집합) 연산을 확인, 서로 연결된 두 노드 A,B를 확인 후 루트 노드 A\', B\'를 찾고 A\'와 B\' 중 번호가 작은 노드를 부모 노드로 설정한다. 마지막 단계는 모든 union(합집합) 연산을 처리할 때까지 첫번째 과정을 반복한다.
   <br><br>
4. 서로소 집합 알고리즘의 시간 복잡도는 간단하게 한다면 O(VM)이고 경로압축 방식을 사용한다면 O(V + M(1 + log<sub>2-M/V</sub>V))다.

### [서로소 집합을 활용한 사이클 판별 p.277](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/graph/CycleDiscrimination.java)
1. 무방향 그래프 내에서 사이클을 판별할 때 서로소 집합을 사용할 수 있다.
   <br><br>
2. 사이클 확인 방법은 각 간선의 루트 노드가 서로 다르다면 두 노드에 대해 union 연산을 수행 한 후 루트 노드가 서로 같은지 확인하는 방법이다. 이 방법을 모든 간선에 대하여 수행한다.

### 신장 트리 p.280
1. 신장 트리(Spanning Tree)란 하나의 그래프가 있을 때 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프를 뜻한다.

### [크루스칼 알고리즘 p.280](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/graph/Kruskal.java)
1. 크루스칼(Kruskal) 알고리즘은 가능한 한 최소한의 비용으로 신장 트리를 찾아야 할 때 쓰인다. 최소 비용으로 만들 수 있는 신장 트리는 '최소 신장 트리'라 부르며 이것을 찾는 알고리즘을 '최소 신장 트리 알고리즘'이라 부른다.
   <br><br>
2. 구체적인 알고리즘은 다음과 같다. 간선 데이터를 오름차순으로 정렬한다 -> 정렬된 간선을 하나씩 확인하며 사이클이 발생하지 않는다면 최소 신장 트리에 포함시킨다. -> 모든 간선을 확인 할 때까지 반복한다.

### [위상 정렬 p.290](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/graph/TopologySort.java)
1. 위상 정렬(Topology Sort)은 순서가 정해져 있는 일련의 작업을 차례대로 수행해야 할 때 사용할 수 있는 알고리즘이다. 이론적으로는 방향 그래프의 모든 노드를 '순서를 거스르지 않도록 순서대로 나열하는 것'이다.
   <br><br>
2. 위상 정렬에선 진입차수(Indegree)란 용어를 사용하는데, 특정한 노드로 '들어오는' 간선의 개수를 의미한다.
   <br><br>
3. 알고리즘은 다음과 같다. 진입차수가 0인 노드를 큐에 넣는다 -> 큐에서 원소를 꺼내 해당 노드에서 출발하는 간선을 그래프에서 제거한다 -> 새롭게 진입차수가 0이 된 노드를 큐에 넣는다 -> 큐가 빌 때까지 반복한다.

### [팀 결정 p.298](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/graph/TeamDecision.java)