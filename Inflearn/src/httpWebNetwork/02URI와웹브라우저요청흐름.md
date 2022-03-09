# URI(Uniform Resource Identifier)
1. URI는 URL(Uniform Resource Locator), URN(Uniform Resource Name) 또는 둘 다 추가로 분류될 수 있다. -> ( URI ( URL, URN ) )
2. Uniform(리소스를 식별하는 통일된 방식), Resource(URI로 식별할 수 있는 모든 것(제한 없음)), Identifier(다른 항목과 구분하는데 필요한 정보), Locator(리소스가 있는 위치를 지정), Name(리소스에 이름을 부여)

# URL 전체 문법
1. scheme://\[userinfo@\]host\[:port\]\[/path\]\[?query\]\[#fragment\] -> https\://www\.google.com:443/search?q=nnagman&hl=ko
2. scheme -> 프로토콜(https) -> 주로 프로토콜(http https, ftp 등등)이 사용된다.
3. userinfo -> URL에 사용자 정보를 포함해서 인증하는 용도 -> 거의 사용하지 않는다. 
4. 호스트명(www\.google.com)
5. 포트 번호(443) -> 생략가능
6. 패스(/search) -> 리소스의 경로, 계층적 구조로 되어 있다.
7. 쿼리 파라미터(q=hello&hl=ko) -> key=value 형태, ?로 시작하고 &로 구분한다 -> query parameter, query string 등으로 불린다. 웹서버에 제공하는 파라미터로 문자 형태다.
8. fragment -> html 내부 북마크 등에 사용 -> 서버에 전송하는 정보는 아니다.

# 웹 브라우저 요청 흐름
1. HTTP 요청 메시지 생성 -> GET /search?q=hello&hl=ko HTTP/1.1 HOST: www\.google.com
2. SOCKET 라이브러리를 통해 전달 -> A: TCP/IP 연결(IP, PORT), B: 데이터 전달
3. TCP/IP 패킷 생성, HTTP 메시지 포함
4. ( TCP/IP 패킷 ( HTTP 메시지 ) ) 이렇게 감싸져서 요청 패킷을 전달한다.
5. HTTP 응답 메시지 -> HTTP/1.1 200 OK Content-Type: text/html;charset=UTF-8 Content-Length : 3423 <html><body>...</body></html>
6. 응답 패킷 도착 -> HTML 렌더링