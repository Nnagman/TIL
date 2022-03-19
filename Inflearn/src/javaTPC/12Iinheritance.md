### 모든 class는 root class인 Object class를 상속받는다. 부모와 자식 관계의 class도 결국 최상위에는 Object class가 있다.
### 
### class들은 부모의 object부터 생성한 뒤 자기 자신의 object가 생성된다. 
### 
### child class의 constructor에는 super()란 method를 통해 parent class의 constructor를 호출할 수 있다. ( super()이면 parameter가 없는 constructor이고 super에 parameter를 추가하여 다른 constructor를 호출 할 수도 있다. )