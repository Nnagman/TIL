# React Essentials
### Server Components
[File Conventions](https://nextjs.org/docs/app/building-your-application/routing#file-conventions)
- Next.js에서 제공하는 special files는 다음과 같다.
- layout, page, loading, not-found, error, global-error, route, template, default

- [Component Hierarchy](https://nextjs.org/docs/app/building-your-application/routing#file-conventions)에 맞게 코드를 작성하면 자동으로 adopting한다.

### Client Components
[Client Components](https://nextjs.org/docs/getting-started/react-essentials#client-components)
- React의 [hydarate](https://react.dev/reference/react-dom/client/hydrateRoot)로 Next.js에선 pre-rendered를 할 수 있다.
- 파일의 최상단에 'use client' 지시어(directive)를 사용하여 해당 코드는 Client Components임을 알릴 수 있다.
- 'use client'는 모든 파일에 명시할 필요는 없다. 클라이언트 모듈들의 최초 진입점(entry point)에 명시하면 된다.

### Patterns
[Moving Client Components to the Leaves](https://nextjs.org/docs/getting-started/react-essentials#moving-client-components-to-the-leaves)
- 어플리케이션의 성능을 위해서 클라이언트 컴포넌트는 가능하면 컴포넌트 트리의 마지막에 위치해야 한다.
- 레이아웃의 전체를 클라이언트 컴포넌트로 만들기 보단 상호작용 하는 로직들만 클라이언트 컴포터넌트로 만들어 따로 import하고 레이아웃은 서버 컴포넌트로 둔다. ( 이러면 레이아웃 안 컴포넌트들의 자바스크립트를 전부 클라이언트로 보낼 필요가 없어진다 )

[Composing Client and Server Components](https://nextjs.org/docs/getting-started/react-essentials#composing-client-and-server-components)
- 서버 컴포넌트와 클라이언트 컴포넌트는 같은 트리에 결합될 수 있다.
- 리액트는 클라이언트에게 결과를 보내기 전에 모든 서버 컴포넌트를 렌더링 한다.

[Nesting Server Components inside Client Components](https://nextjs.org/docs/getting-started/react-essentials#composing-client-and-server-components)
- 'use client'가 명시된 클라이언트 컴포넌트에 서버 컴포넌트가 import되어 사용된다면 추가적으로 서버에 round trip을 해야 한다. 그래서 대신 props를 사용하면 문제는 해결된다.
- 그리고 서버 컴포넌트에서 클라이언트 컴포넌트를 리턴한다면 해당 클라이언트 컴포넌트의 자식으로 추가적인 서버 컴포넌트를 줄 수 있다. ( 링크 코드 확인 )

[Keeping Server-Only Code out of Client Components (Poisoning)](https://nextjs.org/docs/getting-started/react-essentials#keeping-server-only-code-out-of-client-components-poisoning)
- 환경 변수 같은건 클라이언트에게 보여 줄 필요가 없다. 접두사로 NEXT_PUBLIC이 붙이지 않는다면 서버에서만 사용 할 수 있다.
- 환경 변수를 사용하는 서버 컴포넌트를 클라이언트에서도 사용될 수는 있지만 정상적으로 작동이 안될 것이다. 런타임에서 이런 일이 발생하는건 바람직 하지 않다.
- 그래서 'server-only'라는 패키지를 사용하여 빌드 타임에서 해당 문제를 잡아 줄 수 있다.

[Third-party packages](https://nextjs.org/docs/getting-started/react-essentials#third-party-packages)
- 써드파티 패키지는 'use client' 지시어를 사용하지 않는 경우가 있다. 그러므로 서버컴포넌트에서 사용하려면 'use client' 지시어로 감싼 다음 import해야한다.

### Context
[Using context in Client Components](https://nextjs.org/docs/getting-started/react-essentials#using-context-in-client-components)
- 써드파티 패키지와 같이 Context는 클라이언트 컴포넌트에서만 사용 가능하다.

[Sharing data between Server Components](https://nextjs.org/docs/getting-started/react-essentials#rendering-third-party-context-providers-in-server-components)
- '@utils/database'와 같이 모듈을 import하는 이러한 자바스크립트 패턴은 싱글톤을 보장한다.

[Sharing fetch requests between Server Components](https://nextjs.org/docs/getting-started/react-essentials#sharing-fetch-requests-between-server-components)
- fetch 요청은 같은 컴포넌트 트리에 있으면 중복제거 될 수 있다.

# Routing

[Server-Centric Routing with Client-side Navigation](https://nextjs.org/docs/app/building-your-application/routing#server-centric-routing-with-client-side-navigation)
- SPA(Single-Page Application)과 같이 유저가 새로운 라우트로 이동할 때, 페이지 전체를 새로고침 하는것이 아니라 URL만 바뀌고 필요한 세그먼트만 바뀐다.
- 라우터는 리액트 서버 컴포넌트 페이로드를 클라이언트측 인메모리 캐시에 저장 할 것이다. 이를 통해 fetch된 segment를 재사용 할 수 있다.

[Partial Rendering](https://nextjs.org/docs/app/building-your-application/routing#partial-rendering)
- sibling routes간 이동시 레이아웃과 페이지에서 변경된 부분만 fetch 그리고 render를 할 것이다.

### pages-and-layouts
[Templates](https://nextjs.org/docs/app/building-your-application/routing/pages-and-layouts#templates)
- Template는 layout와 같이 자식 layout과 page들을 감싼다. 하지만 template는 다른 자식들로 이동시 인스턴스가 새롭게 만들어진다.
- 특별한 경우가 아니면 layout을 사용하는걸 추천한다.

### Linking and Navigating
[Prefetching](https://nextjs.org/docs/app/building-your-application/routing/linking-and-navigating#prefetching)
- 그 전 페이지 그리고 prefetch한 payload를 클라이언트 메모리에 캐싱한다 ( 서버 io를 줄여줌 )
- 라우트가 static이라면 전부 prefetch하겠지만, dynamic이라면 첫번째 공유 layout과 loading.js만 prefetch해주고 instant loading states로 suspense component의 fallback으로 등록된 Loading 화면을 불러 올 수 있게 해준다
- prefetch는 production에서만 작동하고 link에 prefetch={false}로 비활성화가 가능하다.

### Dynamic Routes
[TypeScript](https://nextjs.org/docs/app/building-your-application/routing/dynamic-routes#typescript)<br/>
![image](https://github.com/Nnagman/TIL/assets/16336810/45dd086a-d0bb-4c6d-823a-d7009de52273)

### Loading UI and Streaming
[Loading UI and Streaming](https://nextjs.org/docs/app/building-your-application/routing/loading-ui-and-streaming#streaming-with-suspense)
- Streaming Server Rendering과 Selective Hydration로 TTFB, FCB를 줄이고 TTI를 향상시켜준다.

### [Error Handling](https://nextjs.org/docs/app/building-your-application/routing/error-handling)

### Parallel Routes
[Convention](https://nextjs.org/docs/app/building-your-application/routing/parallel-routes#convention)<br/>
![image](https://github.com/Nnagman/TIL/assets/16336810/5361bea7-9c8c-462a-9a8f-9527f05d424c)

[Unmatched Routes](https://nextjs.org/docs/app/building-your-application/routing/parallel-routes#unmatched-routes)
- default.js는 url에 일치하는 파일이 없다면 렌더링된다. 만약에 default.js도 없다면 404.

[Modals](https://nextjs.org/docs/app/building-your-application/routing/parallel-routes#modals)
- 예를 들어 Modal같은 경우 사용하는 경우에만 render하기 위해 null을 return하는 defualt.js를 만들어 줄 수 있다.

### Intercepting Routes
[Convention](https://nextjs.org/docs/app/building-your-application/routing/intercepting-routes#convention)<br/>
![image](https://github.com/Nnagman/TIL/assets/16336810/da6171d3-09a2-41a6-9c6d-8d793ee529e9)
- [예시](https://github.com/vercel-labs/nextgram/tree/main/src/app)

### Route Handlers
[Route Resolution](https://nextjs.org/docs/app/building-your-application/routing/router-handlers#route-resolution)
<br/>
![image](https://github.com/Nnagman/TIL/assets/16336810/f2fb6c21-279c-4125-8ad6-b6e96e3fce46)
- page.js와 route.js를 같은 경로에 두면 안된다. Each route.js or page.js file takes over all HTTP verbs for that route.

[Revalidating Static Data](https://nextjs.org/docs/app/building-your-application/routing/router-handlers#revalidating-static-data)
- static 요청의 경우 cache 유효 기간을 설정 할 수 있다.

### [Middleware](https://nextjs.org/docs/app/building-your-application/routing/middleware)
- Nextjs 미들웨어는 특정 요청에 대해 설정한 내용대로 응답을 하게 해준다.

### [Project Organization and File Colocation](https://nextjs.org/docs/app/building-your-application/routing/colocation)
- 프로젝트 폴더 구조에 대해서 설명함.

### [Internationalization](https://nextjs.org/docs/app/building-your-application/routing/internationalization)
- 국제화에 대해 설명함
