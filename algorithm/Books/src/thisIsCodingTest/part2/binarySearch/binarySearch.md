## 범위를 반씩 좁혀가는 탐색 p.186

### 이진 탐색 : 반으로 쪼개면서 탐색하기 p.188
1. 이진 탐색(Binary Search)은 배열 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘이다. 시작점, 끝점 그리고 중간점이란 변수 3개를 사용한다. 찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교해서 원하는 데이터를 찾는다.
   <br><br>
2. 이진 탐색의 시간복잡도는 O(logN)이다. 한번확인 할 때 마다 확인해야하는 원소가 절반씩 줄어들기 때문이다. 연산복잡도는 단계마다 2로 나누는 것과 동일하므로 연산 횟수는 log₂N에 비례한다고 볼 수 있고 빅오 표기법으로 하면 O(logN) 이다.

### 이진 탐색 트리 p.193
1. 이진 탐색 트리란 이진 탐색이 가능하도록 만든 자료구조다. 최상위 부모 노드에는 중간 값이 위치하며 왼쪽에는 부모노드보다 작은 값, 오른쪽에는 부모노드보다 큰 값이 들어간다.

### [부품 찾기 p.197](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/binarySearch/FindingParts.java)
1. 손님이 요청한 부품들을 가지고 있는지 확인하는 문제다.
   <br><br>
2. 이진탐색을 위해서 가지고 있는 부품들이 담겨있는 배열을 정렬한다. 정렬 후 손님이 요청한 부품들이 배열에 있는지 이진 탐색으로 확인 후 'YES' 또는 'NO'를 출력한다.

### [떡볶이 떡 만들기 p.201](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/binarySearch/MakingDdeokBokki.java)
1. 여러 길이의 떡볶이 떡들이 주어졌을 떄, 손님이 원하는 떡 길이 만큼 떡을 뽑기 위해 떡을 자른다. 이때 자를 수 있는 최대 길이를 구해야 한다.
   <br><br>
2. 이진탐색을 사용해서 푸는 문제다. 여기선 최적화 문제를 선택 문제로 바꾸어 해결하는 기법인 파라메트릭 서치(parametric search)를 사용한다. 떡들의 길이 중 최대 길이가 10억이다. 0 ~ 10억을 이진 검색으로 검색하면 총 31번만 검색하면 된다. 이진 검색으로 해당 길이만큼 떡을 잘랐을 때 나오는 값이 손님이 원하는 길이의 떡보다 크거나 같다면 정답 변수에 해당 길이를 넣는다. 이렇게 검색해서 마지막으로 담은 길이가 정답이다.