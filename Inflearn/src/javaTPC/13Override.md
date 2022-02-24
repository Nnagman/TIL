### Inheritance relationship에서 inheritanced한 하위 class가 상위 class의 동작을 수정하는 것

### Parent d = new Child();로 instance를 생성 후 d.func()를 하면 child class의 func()에 접근하게 된다. 하지만 override를 하지 않았을 경우 parent class의 func()에 접근한다.

### inheritance 관계에서 overriding의 장점은 child class 내부의 소스코드를 노출 시키지 않고도 간접적으로 child class의 method를 사용할 수 있다는 점이다. ( Parent d = new Child() ) 즉, child class의 동작 방식을 모를 때, 간접적으로 이용할 수 있는 방법이다.

### @override란 annotation을 overriding한 method에 붙이는 이유는 해당 method가 overriding했단 것을 명시해서 나중에 헷갈리지 않게 할 수 있으며 추후에 parent class가 변경되었을 때, child class에서 컴파일 오류가 나서 작동방식이 바뀌는 것을 쉽게 감지할 수 있다.