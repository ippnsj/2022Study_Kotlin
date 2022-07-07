fun main() {
    val obj1:SubClass1 = SubClass1()
    val obj2:SubClass2 = SubClass2()

    // 부모 클래스 타입 참조변수에 담는다.
    // 스마트 캐스팅 발생
    val super1:SuperClass1 = obj1
    // 인터페이스 타입 참조변수에 담는다.
    // 스마트 캐스팅 발생
    val inter1:Inter1 = obj2

    println("---------------------------")

    // as : 지정된 클래스 타입으로 강제 변환하는 연산자
    // 만약 객체가 지정된 클래스타입과 관계가 없을 경우 오류가 발생한다.
    // 형 변환이 발생한 참조 변수는 변환된 타입을 유지한다.
    super1 as SubClass1
    inter1 as SubClass2
    super1.subMethod1()
    inter1.subMethod2()

    println("---------------------------")

    // is : 형 변환이 가능하면 변환을 하고 true를 반환한다.
    // if 문으로 구성하여 사용하며
    // if 문 내에서만 변환된 타입을 사용하고 if 문을 나가게 되면 변환되기 전의 타입으로 다시 변경된다.
    val obj3:SubClass1 = SubClass1()

    val chk1 = obj3 is SuperClass1
    println("chk1 : $chk1")
    // val chk2 = obj3 is Inter1

    val super2:SuperClass1 = obj3
    val chk2 = super2 is SubClass1
    println("chk2 : $chk2")
    val chk3 = super2 is Inter1
    println("chk3 : $chk3")

    // super2.subMethod1()
    if(super2 is SubClass1) {
        // super2 as SubClass1
            // is 연산자 값이 true라면 형변환이 가능한 상황이므로 스마트 캐스팅 발생
        super2.subMethod1()
    }
    // super2.subMethod1()

    println("---------------------------")

    val obj10:SubClass1 = SubClass1()
    val obj11:SubClass2 = SubClass2()

    anyMethod(obj10)
    anyMethod(obj11)
    anyMethod(100)
    anyMethod("문자열")

    println("---------------------------")

    // < 기본 타입의 형 변환 >
    // 참조 변수의 타입이 변경되는 것이 아닌 새로운 객체가 생성되어 반환된다.
    // toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble(), toChar()
    val number1:Int = 100
    val number2:Long = number1.toLong()
    println("number2 : $number2")

    val str1:String = "100"
    val number3:Int = str1.toInt()
    println("number3 : $number3")

    /*val str2:String = "안녕하세요"
    val number4:Int = str2.toInt()
    println("number4 : $number4")*/

}

open class SuperClass1

interface Inter1

class SubClass1 : SuperClass1() {
    fun subMethod1() {
        println("SubClass1의 subMethod1 입니다.")
    }
}
class SubClass2 : Inter1 {
    fun subMethod2() {
        println("SubClass2의 subMethod2 입니다.")
    }
}

fun anyMethod(obj:Any) {
    if(obj is SubClass1) {
        obj.subMethod1()
    }
    else if(obj is SubClass2) {
        obj.subMethod2()
    }
    else if (obj is Int) {
        println("정수입니다.")
    }
    else if(obj is String) {
        println("문자열입니다.")
    }
}