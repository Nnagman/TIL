# 모든 것이 HTTP(HyperTextTransferProtocol)
1. HTTP 메시지에 모든 것을 전송 -> HTML, TEXT, IMAGE, 음성, 영상, 파일, JSON, XML(API) -> 거의 모든 형태의 데이터 전송 가능 -> 서버 간에 데이터를 주고 받을 때도 대부분 HTTP 사용

### 기반 프로토콜
1. TCP(HTTP/1.1, HTTP/2), UDP(HTTP/3)
2. 현재 HTTP/1.1 주로 사용, HTTP/2, HTTP/3도 점점 증가

### HTTP 특징
1. 클라이언트 서버 구조
2. 무상태 프로토콜(stateless), 비연결성
3. HTTP 메시지
4. 단순함, 확장 가능

# 클라이언트 서버 구조
1. Request Response 구조
2. 클라이언트는 서버에 요청을 보내고, 응답을 대기
3. 서버가 요청에 대한 결과를 만들어서 응답

# Stateful, Stateless

### Stateless - 무상태
1. 서버가 클라이언트의 상태를 보존하지 않는다.
2. 장점: 서버 확장성 높음(스케일 아웃) -> 고객(클라이언트)와 점원(서버)를 예시로 들면 점원이 아무리 바뀌어도 고객에겐 영향을 끼치지 않는다.(무상태) 이를 활용하면 무한히 확장할 수 있다.(스케일아웃 가능)
3. 단점: 클라이언트가 추가 데이터 전송

### Stateful - 상태 유지
1. 클라이언트-중계서버-서버 형식으로 메시지를 주고 받다가 서버가 끊겨 버리면 상태가 날아가기 때문에 모든 과정을 처음부터 다시 해야한다.

### Stateless - 실무 한계
1. 모든 것을 무상태로 설계 할 수 있는 경우도 있고 없는 경우도 있다.
2. 무상태 -> 로그인이 필요 없는 단순한 서비스 소개 화면
3. 상태 유지 -> 로그인한 사용자의 경우 로그인 했다는 상태를 서버에 유지
4. 일반적으로 브라우저 쿠키와 서버 세션 등을 사용해서 상태 유지 -> 상태 유지는 최소한만 사용

# 비 연결성(connectionless)
1. 연결을 유지하는 모델 -> TCP/IP 연결(요청 후 응답 -> 서버는 연결을 계속 유지 -> 서버 자원 소모)
2. 연결을 유지하지 않는 모델 -> TCP/IP 연결(요청 후 응답 -> 서버는 연결 유지 X -> 최소한의 자원 유지)
3. HTTP는 기본이 연결을 유지하지 않는 모델 -> 일반적으로 초 단위 이하의 빠른 속도로 응답 -> 1시간 동안 수천명이 서비스를 사용해도 실제 서버에서 동시에 처리하는 요청을 수십개 이하로 매우 작음(웹 브라우저에서 계속 연속해서 검색 버튼을 누르진 않는다) -> 서버 자원을 매우 효율적으로 사용할 수 있음

### 한계와 극복
1. TCP/IP 연결을 새로 맺어야 함 - 3way handshake 시간 추가
2. 웹 브라우저로 사이트를 요청하면 HTML 뿐만 아니라 자바스크립트, css 추가 이미지 등 수 많은 자원이 함께 다운로드
3. 지금은 HTTP 지속 연결(Persistent Connections)로 문제 해결 -> HTML, 자바스크립트, 이미지 등 응답을 마칠때까지 요청을 유지함
4. HTTP/2, HTTP/3에서 더 많은 최적화

# HTTP 메시지

### HTTP 메시지 구조
1. start-line 시작 라인 (GET /search?q=hello&hl=ko HTTP/1.1, HTTP/1.1 200 OK)
2. header 헤더 (Host: www\.google.com, Content-Type: text/html;charset=UTF-8 Content-Length: 3423)
3. empty line 공백 라인 (CRLF, Carriage Return, 엔터)
4. message body (request도 가능 함, <html><body>...</body></html>)

### 시작라인 - 요청메시지 
1. start-line = request-line / status-line -> request-line = method(HTTP 메서드) SP(공백) request-target SP HTTP-version CRLF
2. HTTP 메서드는 GET, POST, PUT, DELETE 등으로 서버가 수행해야 할 동작을 지정한다. GET은 리소스 조회 POST는 요청 내역 처리다.
3. 요청 대상 -> absolute-path\[\?query\](절대경로\[\?쿼리\]) -> 절대경로는 "/"로 시작하는 경로다 -> http\://...\?x=y와 같이 다른 유형의 경로지정 방법도 있다.

### 시작라인 - 응답메시지
1. start-line = request-line / status-line -> status-line = HTTP-version SP status-code(HTTP 상태 코드) SP reason-phrase(사람이 이해할 수 있는 짧은 상태 코드 설명 글) CRLF

### 헤더
1. header-field = field-name(Host, Content-Type, Content-Length, 대소문자 구분 X) ":" OWS field-value(www\.google.com, text/html..., 3423) OWS (OWS:띄워쓰기 허용)
2. HTTP 전송에 필요한 모든 부가정보가 있다 -> 메시지 바디의 내용과 크기, 압축, 인증, 요청 클라이언트(브라우저) 정보, 서버 애플리케이션 정보, 캐시 관리 정보 등이 있다.
3. 표준 헤더가 너무 많다.
4. 필요시 임의의 헤더 추가 가능 (helloworld: hiyo)

### HTTP 메시지 바디
1. 실제 전송할 데이터 -> HTML 문서, 이미지, 영상, JSON 등등 byte로 표현할 수 있는 모든 데이터 전송 가능