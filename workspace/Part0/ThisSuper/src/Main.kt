fun main() {
    var obj1 = TestClass1()
    obj1.testMethod1()

    var obj2 = SubClass()
    obj2.subMethod1()
}

class TestClass1(var a2:Int) {
    var a1 = 100

    constructor() : this(100) {
        // 보조 생성자는 반드시 주 생성자를 호출해야 한다.
    }

    fun testMethod1() {
        var a1 = 200

        println("a1 : $a1")
        println("this.a1 : ${this.a1}")

        fun testMethod2() {
            println("testMethod1 내부의 testMethod2")
        }

        testMethod2()
        this.testMethod2()
    }

    fun testMethod2() {
        println("testMethod2")
    }
}

open class SuperClass(var a2:Int) {
    open var a1 = 100

    open fun superMethod1() {
        println("SuperClass의 superMethod1")
    }
}

class SubClass : SuperClass(100) {
    override var a1 = 1000

    fun subMethod1() {
        println("a1 : $a1")
        println("super.a1 : ${super.a1}")

        superMethod1()
        super.superMethod1()
    }

    override fun superMethod1() {
        super.superMethod1() // 만약 부모 메서드 호출 시 오류가 나지 않는다면 부모 메서드를 호출하는 것을 권장한다.
        println("SubClass의 superMethod1")
    }
}

class SubClass2 : SuperClass {
    constructor(a2:Int) : super(a2) {

    }

    constructor(a1:Int, a2:Int) : super(a2)
}
