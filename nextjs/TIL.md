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
