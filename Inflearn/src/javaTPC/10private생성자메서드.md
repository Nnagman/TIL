### Constructor가 priavte 접근제어를 가지면 object를 생성할 수 없다는 뜻이다. private contructor만 있는 class의 member에 접근하려면 static이 되어야지 사용가능하다. 그리고 constructor가 private인 class는 object 생성을 못한다.

### static member는 접근할때 class 이름으로 접근한다.(class.method()) class를 사용하는 시점에서 static 멤버는 먼저 자동으로 메모리에 로딩된 후 호출된다.

### static이 아닌 method는 instance method라 하고 static인 method는 class method라 한다. 그러니깐 object를 instance화 해서 사용해야지 접근 가능한 method 이기 때문에 instance method라 부르는 것이고 instance화 하지 않아도 접근 가능한 method는 class method라 부른다.