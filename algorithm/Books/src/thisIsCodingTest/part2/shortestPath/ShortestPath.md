## 가장 빠른 길 찾기 p.230
최단 경로 문제는 보통 그래프를 이용해 표현한다. 각 지점은 그래프에서 '노드'로 표현되고 지점 간 연결된 도로는 '간선'이라 표현된다.

### 다익(데이크)스트라 최단 경로 알고리즘 p.231
다익(데이크)스트라(Dijkstra) 최단 경로 알고리즘은 그래프에서 여러 개의 노드가 있을 때, 특정한 노드에서 출발하여 각각의 노드로 가는 최단 경로를 구해준다. '음의 간선'이 없을 때 정상적으로 작동한다.

### [개선된 다익스트라 알고리즘 p.239](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/shortestPath/ImprovedDijkstraAlgorithm.java)
1. 개선된 다익스트라 알고리즘의 시간 복잡도는 O(ElogV)를 보장한다. V는 노드의 개수, E는 간선의 개수다.
   <br><br>
2. 힙(Heap) 자료구조를 사용한다. 힙은 우선순위 큐(Priority Queue)를 구현하기 위하여 사용하는 자료구조 중 하나다. 우선순위 큐는 내부적으로 최소힙 또는 최대힙을 쓴다.

### [플로이드 워셜 알고리즘 p.251](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/shortestPath/FloydWarshallAlgorithm.java)
1. Floyd-Warshall Algorithm은 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야 하는 경우에 사용한다.
   <br><br>
2. Dijkstra는 단계마다 최단 거리를 찾는다. Floyd-Warshall도 거쳐 가는 노드마다 알고리즘을 수행하지만 매번 방문하지 않은 노드 중에서 최단 거리를 갖는 노드를 찾진 않는다.
   <br><br>
3. 점화식은 D<sub>a</sub><sub>b</sub> = min(D<sub>a</sub><sub>b</sub>, D<sub>a</sub><sub>k</sub> + D<sub>k</sub><sub>b</sub>) 이다

### [미래도시 p.259](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/shortestPath/FutureCity.java)

### [전보 p.262](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/shortestPath/Telegram.java)
