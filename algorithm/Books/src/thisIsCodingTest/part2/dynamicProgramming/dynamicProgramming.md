## 다이나믹 프로그래밍 p.207

### 중복되는 연산을 줄이자 p. 208

1. 다이나믹 프로그래밍은 큰 문제를 작은 문제로 나눌 수 있고 작은 문제에서 구한 답이 큰 문제에서도 동일할 때 사용할 수 있다.
   <br><br>
2. 메모이제이션(Memoization) 기법을 활용하여 중복연산을 피할 수 있다. 한 번 구한 결과를 메모리에 저장해두고 같은 식을 다시 호출하면 저장한 결과를 그대로 가져오는 기법이다. 메모이제이션에서 저장하는
   방법을 캐싱(Caching)이라고도 한다.
   <br><br>
3. 큰 문제를 해결하기 위해 작은 문제를 호출하는 탑다운 방식, 작은 문제부터 해결해 나가는 보텀업 방식이 있다.

### [1로 만들기 p.217](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/dynamicProgramming/MakeItOne.java)
1. 1이상 30,000이하인 x를 5,3,2로 나누거나 1을 빼는 과정을 반복해서 1을 만들어야 한다. 이때 최소 몇번을 반복해야 하는지 구하라.
   <br><br>
2. Memoization을 위해 DP 테이블을 만들고 BottomUp 방식으로 Dynamic Programming을 수행한다.
   <br><br>
3. 점화식은 a<sub>i</sub> = min(a<sub>i-1</sub>, a<sub>i/2</sub>, a<sub>i/3</sub> + a<sub>i/5</sub>) + 1다.

### [개미 전사 p.220](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/dynamicProgramming/AntWarrior.java)
1. 3이상 100 이하인 n개 만큼 식량창고가 주어진다. 각 창고당 식량 개수는 0이상 1000이하 이다. x번째 창고를 거쳤다면 x+2번째 창고부터 갈 수 있다. 이때 얼마나 많은 식량을 가져갈 수 있는지 구하라.
   <br><br>
2. Memoization을 위해 DP 테이블을 만들고 BottomUp Dynamic Programming을 수행한다.
   <br><br>
3. 점화식은 a<sub>i</sub> = max(a<sub>i-1</sub>, a<sub>i-2</sub> + k<sub>i</sub>)다.

### [바닥 공사 p.223](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/dynamicProgramming/FloorConstruction.java)
1. 1이상 1,000 이하인 n만큼 길이를 가진 타일이 주어진다. 타일은 1x2, 2x1, 2x2 크기의 덮개로 채워야 한다. 이때 타일을 채우는 모든 경우의 수를 796,796으로 나눈 나머지를 구하라.
   <br><br>
2. Memoization을 위해 DP 테이블을 만들고 BottomUp Dynamic Programming을 수행한다.
   <br><br>
3. 점화식은 a<sub>i</sub> = a<sub>i-1</sub> + a<sub>i-2</sub> x 2다.

### [효율적인 화폐 구조 p.226](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/dynamicProgramming/EfficientMoneyStructure.java)
1. 1이상 1,001 이하인 n만큼 화폐가 주어지고 1이상 10,000 이하인 m의 액수가 주어진다. m만큼의 액수를 만들기 위해선 화폐가 최소 얼마까지 쓰이는지 구하라. 만약 만들 수 없다면 -1을 반환한다.
   <br><br>
2. Memoization을 이해 크기가 m인 테이블을 만들고 10,001로 초기화한다. 그리고 화폐 값들을 받기 위해 크기가 n인 테이블을 만든다. BottomUp Dynamic Programming을 수행한다.
   <br><br>
3. 점화식은 a<sub>i-k</sub>를 만드는 방법이 존재할 경우 a<sub>i</sub> = min(a<sub>i</sub>, a<sub>i-k</sub> + 1)고 아닐 경우 a<sub>i</sub> = 10,001다.
