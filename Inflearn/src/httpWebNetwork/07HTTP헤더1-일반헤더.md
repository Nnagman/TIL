# HTTP 헤더 개요
1. header-field = field-name ":" OWS field-value OWS (OWS:띄워쓰기 허용, field-name은 대소문자 구분 없음)
2. HTTP 전송에 필요한 모든 부가정보가 담겨 있다. -> 필요시 임으의 헤더 추가 가능(helloworld:yo)

### HTTP BODY - RFC7230(최신)
1. 메시지 본문(message body)을 통해 표현 데이터 전달 -> 메시지 본문 = 페이로드(payload)
2. 표현은 요청이나 응답에서 전달 할 실제 데이터

# 표현
1. Content-type -> 표현 데이터의 형식 -> 미디어 타입, 문자 인코딩
2. Content-Encoding -> 표현 데이터의 압축 방식
3. Content-Language -> 표현 데이터의 자연 언어
4. Content-Length -> 표현 데이터의 길이 -> 바이트 단위
5. 표현 헤더는 전송, 응답 둘 다 사용

# 콘텐츠 협상 - 클라이언트가 선호하는 표현 요청
1. Accept -> 클라이언트가 선호하는 미디어 타입 전달
2. Accept-Charset -> 클라이언트가 선호하는 문자 인코딩
3. Accept-Encoding -> 클라이언트가 선호하는 압축 인코딩
4. Accept-Language -> 클라이언트가 선호하는 자연 언어
5. 협상 헤더는 요청시에만 사용한다.

### 협상과 우선순위
1. q(Quality Values) 값 사용 -> 0~1, 클수록 높은 우선순위 -> 생략하면 1
2. Accept-Language: ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7
3. 구체적인 것이 우선한다.
4. 구체적인 것을 기준으로 미디어 타입을 맞춘다.

# 전송 방식
1. 단순 전송 -> Content-Length
2. 압축 전송 -> Content-Encoding + 단순 전송
3. 분할 전송 -> Transfer-Encoding
4. 범위 전송 -> Content-Range

# 일반 정보
1. From -> 유저 에이전트의 이메일 정보 -> 검색 엔진 같은 곳에서 주로 사용, 요청에서 사용
2. Referer -> 이전 웹 페이지 주소 -> 요청에서 사용 ( referer는 referrer의 오타다)
3. User-Agent -> 유저 에이전트 애플리케이션 정보 -> 클라이언트의 애플리케이션 정보, 통계 정보 -> 어떤 종류의 브라우저에서 장애가 발생하는지 파악 가능, 요청에서 사용
4. Server -> 요청을 처리하는 ORIGIN 서버의 소프트웨어 정보 -> 응답에서 사용
5. Date -> 메시지가 발생한 날짜와 시간 -> 응답에서 사용

# 특별한 정보
1. Host -> 요청한 호스트 정보(도메인) -> 요청에서 사용, 필수 -> 하나의 서버에가 여러 도메인을 처리해야 할 때, 하나의 IP 주소에 여러 도메인이 적용되어 있을 때
2. Location -> 페이지 리다이렉션 -> 3xx(Redirection), 201(Created, 요청에 의해 생성된 리소스 URI)
3. Allow -> 허용 가능한 HTTP 메서드 -> 405(Method Not Allowed)에서 응답에 포함해야함
4. Retry-After -> 유저 에이전트가 다음 요청을 하기까지 기다려야 하는 시간 -> 503(Service Unavailable, 서비스가 언제까지 불능인지 알려줄 수 있음)

# 인증
1. Authorization -> 클라이언트 인증 정보를 서버에 전달
2. WWW-Authenticate -> 리소스 접근시 필요한 인증 방법 정의 -> 401(Unauthorized) 응답과 함께 사용

# 쿠키
1. Set-Cookie -> 서버에서 클라이언트로 쿠키 전달(응답)
2. Cookie -> 클라이언트가 서버에서 받은 쿠키를 저장하고 HTTP 요청시 서버로 전달
3. 쿠키는 사용자 로그인 세션 관리, 광고 정보 트래킹로 쓰인다.

### 쿠키 - 생명주기
1. expires(만료일), max-age(지속 시간, 초 단위)
2. 세션 쿠키 -> 만료 날짜를 생략하면 브라우저 종료시 까지만 유지
3. 영속 쿠키 -> 만료 날짜를 입력하면 해당 날짜까지 유지

### 쿠키 - 도메인
1. 명시 -> 명시한 문서 기준 도메인 + 서브 도메인 포함 (domain=example.org)
2. 생략 -> 현재 문서 기준 도메인만 적용 -> example.org에서 생성했다면 dev.example.org에는 쿠키 미접근

### 쿠키 - 경로
1. 이 경로를 포함한 하위 경로 페이지만 쿠키 접근 -> 일반적으로 path=/ 루트로 지정

### 쿠키 - 보안
1. Secure -> 쿠키는 http, https 구분하지 않고 전송 -> Secure은 https인 경우에만 전송
2. HttpOnly -> XSS 공격 방지 -> 자바스크립에서 접근 불가
3. SameSite -> XSRF 공격 방지 -> 요청 도메인과 쿠키에 설정된 도메인이 같은 경우만 쿠키 전송