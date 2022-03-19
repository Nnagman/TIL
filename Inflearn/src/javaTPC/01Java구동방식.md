### .java 확장자를 가진 source file을 1차 compile을 거쳐 실행가능한 .class 확장자를 가진 파일로 변환한다. 이때, java에서 byte code로 변환된다.
###
### class 파일은 바로 실행가능한 파일이 아닌 중간어 코드다. 
###그렇기 때문에 별도로 실행 해주는 엔진이 필요한데, 그것을 JVM(Java Virtual Machine)이라 한다. 
### JVM은 실행하는 OS에 맞게 다시 compile하여 실행한다. 물론, JVM은 메모리에 탑재되어 실행된다...