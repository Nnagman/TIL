### Method Area( static zone, non-static zone을로 나뉘며 Method의 byte code가 저장되는 영역이다. )
### Stack Area( Call Stack Frame Area, method가 호출되면 호출정보가 저장되는 영역이다. )
### Heap Area( Object가 생성되는 영역이다. new 연산자 )
### Literal Pool( 문자열(Object) 상수가 저장되는 영역이다. )
### 
### JVM이 class를 실행하는 절차

### 1. 해당 class를 현재 directory에서 찾는다. ( classpath를 사용하여 찾기도 함. )

### 2. 찾으면 class 내부에 있는 static method를 memory로 loading 한다. ( Method Area의 Static Zone에 loading. static 키워드를 사용한 var나 method는 class가 memory에 올라갈 때 자동으로 loading된다. 즉, instance(object) 생성 없이 바로 사용가능 )

### 3. static zone에서 main() method를 실행한다(호출, 시작) 호출되면 main() method의 호출정보가 stack area에 push된다. 여기가 프로그램이 시작되는 부분이다. 

### 4. stack area가 비어 있으면 프로그램이 종료된다.

### class에 있는 static이 아닌 method를 호출하려면 우선 new 연산자로 instance(object)를 heap area에 할당하고 non-static method들의 주소(method area에 있음)를 가리켜야 한다. (pointer)