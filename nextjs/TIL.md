# React Essentials

## Server Components
[File Conventions](https://nextjs.org/docs/app/building-your-application/routing#file-conventions)
- Next.js에서 제공하는 special files는 다음과 같다.
- layout, page, loading, not-found, error, global-error, route, template, default

- [Component Hierarchy](https://nextjs.org/docs/app/building-your-application/routing#file-conventions)에 맞게 코드를 작성하면 자동으로 adopting한다.

## Client Components
[Client Components](https://nextjs.org/docs/getting-started/react-essentials#client-components)
- React의 [hydarate](https://react.dev/reference/react-dom/client/hydrateRoot)로 Next.js에선 pre-rendered를 할 수 있다.
- 파일의 최상단에 'use client' 지시어(directive)를 사용하여 해당 코드는 Client Components임을 알릴 수 있다.
- 'use client'는 모든 파일에 명시할 필요는 없다. 클라이언트 모듈들의 최초 진입점(entry point)에 명시하면 된다.

## Patterns
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

## Context
[Using context in Client Components](https://nextjs.org/docs/getting-started/react-essentials#using-context-in-client-components)
- 써드파티 패키지와 같이 Context는 클라리언트 컴포넌트에서만 사용 가능하다.

[Sharing data between Server Components](https://nextjs.org/docs/getting-started/react-essentials#rendering-third-party-context-providers-in-server-components)
- '@utils/database'와 같이 모듈을 import하는 이러한 자바스크립트 패턴은 싱글톤을 보장한다.

[Sharing fetch requests between Server Components](https://nextjs.org/docs/getting-started/react-essentials#sharing-fetch-requests-between-server-components)
- fetch 요청은 같은 컴포넌트 트리에 있으면 중복제거 될 수 있다.

# Routing

