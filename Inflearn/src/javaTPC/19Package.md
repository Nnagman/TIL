### Package는 기능이 비슷한 class들을 모아서 관리하기 쉽게 package 외부에서 접근하는 것을 막을 때 사용한다.
### 
### package의 class 이름은 2가지다. 
### 기본이름 : PackageClass, 패키지를 포함한 이름 :  org.com.PackageClass
### 
### package 내부에 있는 class의 접근권한이 생략되면 기본적으로 default 접근 권한을 가진다.
### default 접근권한은 package 내부에 있는 class들에게는 public을 외부에 있으면 private 접근권한을 준다.