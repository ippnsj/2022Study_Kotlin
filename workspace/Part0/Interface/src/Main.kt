fun main() {
    val obj1 = TestClass1()
    val obj2 = TestClass2()
    testFun1(obj1)
    testFun2(obj2)

    val obj3 = TestClass3()
    val obj4 = TestClass4()
    testFun3(obj3)
    testFun4(obj4)

    val obj5 = TestClass5()
    testFun3(obj5)
    testFun4(obj5)
}

open abstract class AbstractClass1 {
    open abstract fun abstractMethod1()
}

open abstract class AbstractClass2 {
    open abstract fun abstractMethod2()
}

fun testFun1(obj1:AbstractClass1) {
    obj1.abstractMethod1()
}

fun testFun2(obj2:AbstractClass2) {
    obj2.abstractMethod2()
}

class TestClass1 : AbstractClass1() {
    override fun abstractMethod1() {
        println("TestClass1의 abstractMethod1")
    }
}

class TestClass2 : AbstractClass2() {
    override fun abstractMethod2() {
        println("TestClass2의 abstractMethod2")
    }
}

// 인터페이스는 클래스가 아니므로 객체 생성이 불가능하다.
interface Inter1{
    // 추상 메서드가 아닌 일반 메서드도 사용 가능하다.
    fun inter1Method1(){
        println("Inter1의 inter1Method1 입니다.")
    }

    fun inter1Method2()
}

interface Inter2{
    fun inter2Method1(){
        println("Inter2의 inter2Method1 입니다.")
    }

    fun inter2Method2()
}

fun testFun3(obj1:Inter1){
    obj1.inter1Method1()
    obj1.inter1Method2()
}

fun testFun4(obj1:Inter2){
    obj1.inter2Method1()
    obj1.inter2Method2()
}

class TestClass3 : Inter1{
    override fun inter1Method2() {
        println("TestClass3의 inter1Method2 입니다.")
    }
}

class TestClass4 : Inter2{
    override fun inter2Method2() {
        println("TestClass4의 inter2Method2 입니다.")
    }
}

class TestClass5 : Inter1, Inter2{
    override fun inter1Method2() {
        println("TestClass5의 iner1Method2 입니다.")
    }

    override fun inter2Method2() {
        println("TestClass5의 inter2Method2 입니다.")
    }
}