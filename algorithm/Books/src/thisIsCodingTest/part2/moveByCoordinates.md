## 좌표로 상하좌우 이동하기 p. 112

### (1,1) 좌표에서 출발하여 주어진 명령어로 이동했을 경우 마지막 좌표가 어딘지 구해야 한다.

### 명령어는 L, R, U, D로 각각 왼쪽, 오른쪽, 위, 아래로 움직이는 명령어다.

<br>

n = 공간의 크기, moves = 명령어들

```
dx = {0,0,-1,1}, dy = {-1,1,0,0};
moveTypes = {"L","R","U","D"}
```

### dx와 dy만 본다면 의미가 없는 배열 2개가 생기는 것이지만 moveTypes와 함께 본다면 의미가 생긴다.

### L의 dy의 0번째 인덱스의 값과 R은 dy의 1번째의 인덱스의 값과 연결 될 수 있다.

<br>

nx = 현재 x 좌표값, ny = 현재 y 좌표값
<br>

```
if ("L" == moveTypes[0]) {
    nx = nx + dx[0];
    ny = ny + dy[0];
}
```

### L이란 명령어가 주어졌을 때, moveTypes의 값 중 일치하는 값의 인덱스에 해당하는 dx와 dy값을 nx와 ny에 더하면 된다.

### 이 과정을 반복하면 명령어를 전부 수행 한 후의 좌표값을 구할 수 있을 것이다.