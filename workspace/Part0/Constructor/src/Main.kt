fun main() {
    val obj1 = TestClass1("789")
    println("obj1 : $obj1")

    println("----------------------------")

    val obj2 = TestClass1("789")
    println("obj2.a : ${obj2.a}")

    println("----------------------------")

    val obj3 = TestClass2()
    println("obj3 : $obj3")
    println("obj3.v1 : ${obj3.v1}")
    println("obj3.v2 : ${obj3.v2}")

    val obj4 = TestClass2(100, 200)
    println("obj4 : $obj4")
    println("obj4.v1 : ${obj4.v1}")
    println("obj4.v2 : ${obj4.v2}")

    println("----------------------------")

    val obj5 = TestClass3(100, 200)
    val obj6 = TestClass4(1000, 2000)
    println("obj5.a1 : ${obj5.a1}")
    println("obj5.a2 : ${obj5.a2}")
    println("obj6.a1 : ${obj6.a1}")
    println("obj6.a2 : ${obj6.a2}")

    println("----------------------------")

    val obj7 = TestClass5(100, 200)
    println("obj7.a1 : ${obj7.a1}")
    println("obj7.a2 : ${obj7.a2}")

    println("----------------------------")

    val obj8 = TestClass5(100)
    val obj9 = TestClass5(100, 1000)
}

class TestClass1 {
    var a = "123"

    init {
        this.a = "456"
        println("객체가 생성되면 자동으로 동작되는 부분입니다.")
    }

    constructor(a:String) {
        println(this.a)
        this.a = a
    }
}

class TestClass2 {
    var v1 = 0
    var v2 = 0

    // 보조 생성자
    constructor() {
        println("매개 변수가 없는 생성자")
    }

    constructor(a1:Int, a2:Int) {
        println("매개 변수가 두 개인 생성자")
        v1 = a1
        v2 = a2
    }
}

// 주 생성자
class TestClass3(var a1:Int, val a2:Int) // a1, a2가 매개 변수로 만들어진다.
class TestClass33(a1:Int, a2:Int) // a1, a2는 매개 변수가 아니다.
class TestClass4 constructor(var a1:Int, val a2:Int)

class TestClass5(var a1:Int, val a2:Int) {
    init {
        println("init 코드 수행")
        println("a1 : $a1")
        println("a2 : $a2")
    }

    constructor(a1:Int) : this(a1, 100){
        println("보조 생성자 호출")
    }
}