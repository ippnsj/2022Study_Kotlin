fun main() {
    val obj1 = TestClass1()
    println("obj1.a1 : ${obj1.a1}")
    println("obj1.a2 : ${obj1.a2}")

    // println("obj1.a3 : ${obj1.a3}")
    obj1.testMethod1()
    println("obj1.a3 : ${obj1.a3}")

    println("obj1.a4 : ${obj1.a4}")
}

class TestClass1 {
    var a1 = 100
    var a2:Int
    // primitive property는 불가능하다.
    // ex. Int, Double, ...
    lateinit var a3:String

    // val로 선언된 변수는 lateinit으로 지연 초기화하는 것이 불가능하다.
    // val로 선언된 변수는 lazy 코드 블록을 이용하면 되는데,
    // 이는 나중에 프로퍼티의 값을 세팅해준다는 의미가 아닌 사용할 때 값을 초기화 한다는 의미를 가지고 있다.
    // 메모리 절약이 가능하다.
    val a4:Int by lazy {
        println("a4 init")
        123
    }

    init{
        a2 = 200
    }

    fun testMethod1() {
        // :: => reflecion
        // 해당 객체를 사용한 class가 무엇인지 확인이 가능하다.
        if(!::a3.isInitialized) {
            a3 = "문자열"
        }
        println("a3 : $a3")
    }
}