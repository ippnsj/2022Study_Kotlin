fun main() {
    val obj1 = SubClass1()
    println("obj1.subA1 : ${obj1.subA1}")
    obj1.subMethod1()

    println("obj1.superA1 : ${obj1.superA1}")
    obj1.superMethod1()

    println("-------------------------------")

    // 모든 객체는 부모 클래스형 참조 변수에 담을 수 있다.
    val obj2:SuperClass1 = obj1
    println("obj2.superA1 : ${obj2.superA1}")
    obj2.superMethod1()

    // 부모 클래스형 참조 변수를 사용하면 부모 클래스에 정의되어 있는 멤버만 사용이 가능하다.
    // println("obj2.subA1 : ${obj2.subA1}")
    // obj2.subMethod1()

    println("-------------------------------")

    val obj3 = SubClass2()
    obj3.superMethod2()

    // 만약 부모의 메서드를 자식에서 Overriding을 했다면
    // 부모형 참조 변수를 통해 자식의 메서드를 호출할 수 있다.
    // 이는 이벤트 처리 방식에서 사건이 발생했을 경우 개발자가 만든 메서드를 호출하기 위해 사용하는 매우 중요한 개념이다.
    val obj4:SuperClass2 = obj3
    obj4.superMethod2()

    println("-------------------------------")

    val obj5 = SuperClass3()
    overridingTest(obj5)

    val obj6 = SubClass3()
    overridingTest(obj6)
}

open class SuperClass1 {
    var superA1 = 100

    fun superMethod1() {
        println("SuperClass1의 superMethod1 입니다")
    }
}

class SubClass1 : SuperClass1() {
    var subA1 = 200
    
    fun subMethod1() {
        println("SubClass1의 subMethod1 입니다")
    }
}

open class SuperClass2 {
    open fun superMethod2() {
        println("SuperClass2의 superMethod2")
    }
}

class SubClass2 : SuperClass2() {
    override fun superMethod2() {
        println("SubClass2의 superMethod2")
    }
}

open class SuperClass3 {
    open fun superMethod3() {
        println("SuperClass3의 superMethod3")
    }
}

class SubClass3 : SuperClass3(){
    override fun superMethod3() {
        super.superMethod3()
        println("SubClass3의 superMethod3")
    }
}

fun overridingTest(obj1:SuperClass3) {
    obj1.superMethod3()
}