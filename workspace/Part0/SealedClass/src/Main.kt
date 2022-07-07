// 열거형은 특정 값을 의미하는 상수들을 모아 관리하는 개념이라면
// Sealed Class는 객체를 모아 관리하는 개념이다.
// 열거형의 경우, 상수에 지정된 값은 절대로 변경이 불가능 하지만
// Sealed Class는 객체가 가지고 있는 변수에 값을 설정하여 지정된 값을 변경하는 것이 가능하다.

// 열거형 사용 시 상수가 의미하는 값을 수시로 변경하거나 다양한 형태로 사용하고자 할 때 사용한다.
// 즉, Sealed Class는 클래스들을 하나로 모아 관리하는 클래스이다.

fun main() {
    val v1 = Number.TWO
    checkNumber(v1)

    val v2 = Number2.SealedTwo(1)
    val v3 = Number2.SealedTwo(2)
    val v4 = Number2.SealedOne(100, 200)
    val v5 = Number2.SealedThree(100, 11.11)

    checkNumber2(v2)
    checkNumber2(v3)
    checkNumber2(v4)
    checkNumber2(v5)
}

enum class Number(val num:Int) {
    ONE(1), TWO(2), THREE(3)
}

fun checkNumber(a1:Number) {
    when(a1) {
        Number.ONE -> println("1 입니다.")
        Number.TWO -> println("2 입니다.")
        Number.THREE -> println("3 입니다.")
    }

    when(a1.num) {
        1 -> println("1 입니다.")
        2 -> println("2 입니다.")
        3 -> println("3 입니다.")
    }
}

sealed class Number2 {
    class SealedOne(val a1:Int, val a2:Int) : Number2()
    class SealedTwo(val a1:Int) : Number2() {
        fun sealedFun2() {
            println("SealedTwo의 sealedFun2 입니다.")
        }
    }
    class SealedThree(val a1:Int, val a2:Double) : Number2()
}

fun checkNumber2(obj1:Number2) {
    when(obj1) {
        is Number2.SealedOne -> {
            println("One 입니다.")
            println(obj1.a1)
            println(obj1.a2)
        }
        is Number2.SealedTwo -> {
            println("Two 입니다.")
            println(obj1.a1)
            when(obj1.a1) {
                1 -> println("1 입니다.")
                2 -> println("2 입니다.")
            }
            obj1.sealedFun2()
        }
        is Number2.SealedThree -> {
            println("Three 입니다.")
            println(obj1.a1)
            println(obj1.a2)
        }
    }
}