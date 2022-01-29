## 아이디어를 코드로 바꾸는 구현 p.104

## 피지컬로 승부하기 p.104
1. 피지컬은 설계한 알고리즘을 구현하는 능력을 말한다. 알고리즘은 간단한데 코드가 지나칠 만큼 길어지는 문제, 특정 소수점 자리까지 출력해야 하는 문제, 문자열이 입력으로 주어졌을 때 한 문자 단위로 끊어서 리스트에 넣어야 하는(파싱을 해야 하는) 문제 등이 피지컬을 요구하는 구현 문제다.
   <br><br>
2. 구현유형에는 두가지 완전탐색과 시뮬레이션이 있다. '모든 경우의 수를 다 계산하는 해결 방법'을 완전탐색, '문제에서 제시한 알고리즘을 한 단계식 차례대로 직접 수행하는 방법'을 시뮬레이션이라 부른다.

### [상하좌우 p.110](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/implementation/UpDownLeftRight.java)
1. 주어진 상화좌우 이동 명령을 NxN 크기의 지도에서 1,1 좌표로 시작하여 모두 수행 했을 때, 위치를 알아내야 하는 문제다.
   <br><br>
2. 주의해야 할 점은 지도를 벗어나는 이동 명령은 무시해야 한다. 반복문으로 이동 명령을 수행할 때, 조건문으로 지도를 벗어나는지 확인 한 뒤 이동해야 한다.

### [시각 p.113](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/implementation/Time.java)
1. 00시00분00초부터 N시59분59초까지 3이 포함되는 시각이 얼마나 있는지 알아내야 하는 문제다.
   <br><br>
2. 시 분 초를 확인하는 3중 반복문으로 3이 포함되어 있는지 확인 후 정답을 증감해주면 된다.

### [왕실의 기사 p.115](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/implementation/RoyalsKnight.java)
1. 8x8 크기의 정원에서 수평으로 2, 수직으로 1 또는 수평으로 1, 수직으로 2를 이동할 수 있는 기사가 있다. 8x8안 특정 좌표에 기사가 있다면 해당 위치에서 이동할 수 있는 경우의 수는 얼마인지 확인하는 문제다.
   <br><br>
2. 이동 할 수 있는 경우의 수를 배열로 만든 뒤, 배열의 내용을 반복문으로 확인하며 해당 위치에서 이동할 경우 정원을 벗어나는지 확인하면 된다.

### [게임 개발 p.118](https://github.com/Nnagman/TIL/blob/main/algorithm/Books/src/thisIsCodingTest/part2/implementation/GameDevelopment.java)
1. NxM 크기의 맵의 특정 위치에서 규칙에 따라 이동할 경우 얼마나 많이 이동 할 수 있는지 확인하는 문제다.
   <br><br>
2. 문제의 지문을 잘 읽어야 하는 시뮬레이션 문제다. 맵의 외곽은 항상 이동할 수 없는 바다로 둘러 쌓여있다. 그렇기 때문에 반복문으로 이동할 경우 맵의 범위를 벗어나는지 확인 할 필요 없이 이동할 위치가 바다인지, 이미 다녀간 곳인지만 확인하면 된다.