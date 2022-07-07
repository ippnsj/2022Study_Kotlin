fun main() {
    val s1 = SubClass1()
    println("s1.subMember1 : ${s1.subMember1}")
    s1.subMethod1()

    println("s1.superMember1 : ${s1.superMember1}")
    s1.superMethod1()

    val s3 = SubClass3(1000)
    println("s3.a1 : ${s3.a1}")
}

open class SuperClass1 { // open 키워드가 없으면 java로 변환될 때 자동으로 final 키워드가 붙는다(상속 불가능하다).
    var superMember1 = 100

    fun superMethod1() {
        println("SuperClass1의 메서드 입니다.")
    }
}

class SubClass1 : SuperClass1() {
    // constructor() : super()
    val subMember1 = 200

    fun subMethod1() {
        println("SubClass1의 메서드 입니다.")
    }
}

open class SuperClass2(val a1:Int)

class SubClass2 : SuperClass2(100)
class SubClass3 : SuperClass2 {
    constructor(a1:Int) : super(a1)
}