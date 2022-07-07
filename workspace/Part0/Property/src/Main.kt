// 외부에서 변수에 대해 직접적인 접근을 차단하는 것을 캡슐화라고 부른다.
// 캡슐화를 적용한 변수에 값을 넣거나 가져다 사용할 수 있도록 setter/getter를 설정한 것을 Property라고 부른다.
// 모든 멤버 변수는 Property이다.

fun main() {
    val obj1 = TestClass1(100, 200)
    println("obj1.a1 : ${obj1.a1}")
    println("obj1.a2 : ${obj1.a2}")

    obj1.a1 = 1000
    println("obj1.a1 : ${obj1.a1}")

    println("-----------------------------")

    val obj2 = TestClass2()
    obj2.v1 = 100
    // obj2.v2 = 200
    println("obj2.v1 : ${obj2.v1}")
    println("obj2.v2 : ${obj2.v2}")

    obj2.v3 = 5000
    println("obj2.v3 : ${obj2.v3}")
}

class TestClass1(var a1:Int, val a2:Int) {
    // 주 생성자만 var, val을 붙여 클래스의 멤버 변수로 Property 생성이 가능하다.
    // 부 생성자는 var, val 키워드를 붙일 수 없다.
    // constructor(var a1:Int, val a2:Int, var a3:Int) : this(a1, a2) {}
}

class TestClass2 {
    var v1:Int = 0
    val v2:Int = 0
    var v3:Int = 100
        get() {
            println("get 호출")
            // 여기서 field는 v3를 의미한다.
            return field
        }
        set(value) {
            println("set 호출")
            // 여기서 field는 v3를 의미한다.
            field = value
        }
}