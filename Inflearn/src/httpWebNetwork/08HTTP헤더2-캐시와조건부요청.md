# 검증 헤더와 조건부 요청
1. 캐시 유효 시간이 초과해서 서버에 다시 요청하면 다음 두 가지 상황이 나타난다. -> 서버에서 기존 데이터를 변경함, 서버에서 기존 데이터를 변경하지 않음
2. 기존 데이터를 변경하지 않았으면 저정해 두었던 캐시를 재사용 할 수 있는데, 검증이 필요하다. 
3. If-Modified-Since -> 304 Not Modified + 헤더 메타 정보만 응답(바디X) -> 클라이언트는 서버가 보낸 응답 헤더 정보로 캐시의 메타 정보를 갱신 -> 캐시에 저장되어 있는 데이터 재활용 
4. If-Modified-Since -> 200 OK + 모든 데이터 전송(BODY 포함)

### Last-Modified, If-Modified-Since 단점
1. 1초미만 단위로 캐시 조정 불가능
2. 날짜 기반의 로직 사용
3. 데이터를 수정했지만 데이터 결과는 같은 경우 대처 불가능 (스페이스나 주석처럼 크게 영향이 없는 변경에서 캐시를 유지해야함)

### ETag, If-None-Match
1. ETag(Entity Tag)
2. 캐시용 데이터에 임의의 고유한 버전 이름을 달아둠 -> 데이터가 변경되면 이름을 바꾸어서 변경함(Hash를 다시 생성) -> Etag만 보내서 같으면 유지
3. If-None-Match -> 304 Not Modified 또는 200 OK
4. 캐시 제어 로직을 서버에서 완전히 관리 -> 클라이언트는 단순히 ETag 값을 서버에 제공, 캐시 메커니즘은 모름

# 캐시와 조건부 헤더

### Cache-Control 캐시 지시어
1. max-age -> 캐시 유효 시간, 초 단위
2. no-cache -> 데이터는 캐시해도 되지만, 항상 origin 서버에 검증하고 사용
3. no-store -> 민감한 정보가 있으니 저장X, 메모리에서 사용하고 최대한 빨리 삭제

### Pragma, Expires 캐시 지시어
1. Pragma -> HTTP 1.0 하위 호환, no-cache
2. Expires -> 하위 호환, expires(날짜 지정) -> max-age 사용 권장 (같이 사용되면 expires는 무시)

### 검증 헤더와 조건부 요청 헤더
1. 검증 헤더(Validator) -> Etag, Last-Modified
2. 조건부 요청 헤더 -> Etag 값 사용(If-Match, If-None-Match), Last-Modified 값 사용(If-Modified-Since, If-Unmodified-Since)

# 프록시 캐시
1. 클라이언트(private 캐시) <-> 프록시 캐시 서버(public 캐시) <-> 원(origin) 서버

# 캐시 무효화

### 확실한 캐시 무효화 응답
1. Cache-Control -> no-cache, no-store, must-revalidate(캐시 만료 후 조회시 원 서버에 검증, 접근 실패 시 반드시 오류가 발생(504, GateWay Timeout))
2. Pragma -> no-cache