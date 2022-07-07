fun main() {
    var obj1 = TestClass1(100, 200)
    var obj2 = TestClass2(100, 200)

    println("obj1.a1 : ${obj1.a1}")
    println("obj1.a2 : ${obj1.a2}")

    println("obj2.a1 : ${obj2.a1}")
    println("obj2.a2 : ${obj2.a2}")

    var obj3 = TestClass1(100, 200, 300)
    var obj4 = TestClass2(100, 200, 300)

    println("obj3.a1 : ${obj3.a1}")
    println("obj3.a2 : ${obj3.a2}")
    println("obj3.a3 : ${obj3.a3}")

    println("obj4.a1 : ${obj4.a1}")
    println("obj4.a2 : ${obj4.a2}")
    println("obj4.a3 : ${obj4.a3}")

    obj3.testMethod1()
    obj4.testMethod2()

    println("-----------------------------")

    var obj5 = TestClass1(100, 200, 300)
    var obj6 = TestClass1(100, 200, 300)
    if(obj5 == obj6) { // 객체의 주소값 비교
        println("obj5와 obj6은 같은 객체 입니다.")
    } else {
        println("obj5와 obj6은 다른 객체 입니다.")
    }

    var obj7 = TestClass2(100, 200, 300)
    var obj8 = TestClass2(100, 200, 300)
    if(obj7 == obj8) { // 주 생성자의 변수값 비교
        println("obj7과 obj8은 같은 객체 입니다.")
    } else {
        println("obj7과 obj8은 다른 객체 입니다.")
    }

    println("-----------------------------")

    // val obj9 = obj5.copy()
    // 주 생성자의 멤버만 복사된다.
    val obj10 = obj7.copy()
    println("obj10.a1 : ${obj10.a1}")
    println("obj10.a2 : ${obj10.a2}")
    println("obj10.a3 : ${obj10.a3}")

    obj10.a1 = 1000
    println("obj7.a1 : ${obj7.a1}")
    println("obj10.a1 : ${obj10.a1}")

    println("-----------------------------")

    val str1 = obj5.toString()
    val str2 = obj7.toString()
    println("str1 : $str1")
    println("str2 : $str2")

    println("-----------------------------")

    val num1 = obj7.component1()
    val num2 = obj7.component2()
    println("num1 : $num1")
    println("num2 : $num2")

    var obj11 = TestClass3(100, 200, 300)
    val num3 = obj11.component1()
    val num4 = obj11.component2()
    val num5 = obj11.component3()
    println("num3 : $num3")
    println("num4 : $num4")
    println("num5 : $num5")

    println("-----------------------------")

    val (num10, num11) = obj7
    println("num10 : $num10")
    println("num11 : $num11")

    val (num12, num13, num14) = obj11
    println("num12 : $num12")
    println("num13 : $num13")
    println("num14 : $num14")
}

class TestClass1(var a1:Int, var a2:Int) {
    var a3:Int = 0

    init {
        println("TestClass1의 init")
    }

    constructor(a1:Int, a2:Int, a3:Int) : this(a1, a2) {
        this.a3 = a3
    }

    fun testMethod1() {
        println("TestClass1의 testMethod1 입니다.")
    }
}

// DataClass는 매개체의 데이터를 관리하는 용도로 사용하는 클래스이다.
// abstract, open, sealed, inner 클래스 정의가 불가능하다.
// 반드시 주 생성자를 가지고 있어야 한다.
data class TestClass2(var a1:Int, var a2:Int) {
    var a3:Int = 0

    init {
        println("TestClass2의 init")
    }

    constructor(a1:Int, a2:Int, a3:Int) : this(a1, a2) {
        this.a3 = a3
    }

    fun testMethod2() {
        println("TestClass2의 testMethod2 입니다.")
    }
}

data class TestClass3(var a1:Int, var a2:Int, var a3:Int)