# 타겟넘버 - DFS / BFS

### https://programmers.co.kr/learn/courses/30/lessons/42839 - 문제 링크

이 문제는 동적계획법(Dynamic Programming)을 활용하여 푸는 문제다.

### 동적계획법으로 풀기
1. 정답을 반환할 재귀 함수(dfs)를 선언한다. 인수는 numbers(숫자배열), n(숫자배열 인덱스), sum(숫자들의 합), target(정답숫자)
2. n이 numbers의 길이와 같은 경우, sum과 target와 같다면 1을 반환하거나 같지 않으면 0을 반환한다.
3. n과 numbers의 길이가 같지 않은 경우 리턴 값으로 자기 자신을 두 가지 경우로 호출한다.
4. 첫번째 경우는 인자값이 numbers, n+1, sum+numbers[n], target
5. 두번째 경우는 인자값이 numbers, n+1, sum-numbers[n], target
6. 최종적으로 dfs는 target을 포함하는 연산의 조합 수를 반환한다.

이번 문제는 재귀함수로 가능한 모든 경우의 수를 불러오며 푸는 문제다. 여기서 쓰이는 문제풀이 방식은 동적계획법과 유사하다.<br/>

임의의 숫자 조합으로 재귀함수로 푸는 과정을 그래프로 그려본다면 더 쉽게 이해 할 수 있을 것이다.