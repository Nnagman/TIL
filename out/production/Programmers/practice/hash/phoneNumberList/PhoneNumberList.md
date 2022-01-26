# 전화번호 목록 - 해시

### https://programmers.co.kr/learn/courses/30/lessons/42577 - 문제 링크

이 문제는 Key Value 쌍으로 이루진 HashMap의 containsKey를 사용하는 문제다.

1. 전화번호의 정보를 담을 HashMap을 선언한다.
2. 전화번호 배열의 원소들을 for문으로 불러오며 Key에는 전화번호를 Value에는 배열의 인덱스 값을 준다.
3. 다시 전화번호 배열의 전화번호를 for문으로 불러온다.
4. 위 for문의 내부에 다시 for문으로 전화번호를 1글자, 2글자, 3글자씩 증감시키며 HashMap에 해당 키가 있는지 확인한다.
5. 만약 있다면 false를 반환하고 아니면 true를 반환한다.

HashMap에서 일치하는 키를 찾는 containsKey는 SQL에서 사용되는 Like와는 달리 정확히 값이 일치해야 한다.
그렇기 때문에 각각의 전화번호를 첫번째 글자부터 마지막 글자까지 1글자씩 증감시키며 해당 키가 존재하는지 확인한다.