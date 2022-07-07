fun main() {
    val a4 = 10
    val a5 = if (a4 == 10) "10 입니다." else "10이 아닙니다." // 코틀린은 삼항연산자가 없다.
    println("a5 : $a5")

    val a6 = if (a4 == 10) {
        println("블록 1 수행")
        "10 입니다." // 마지막에 작성된 값이 저장된다.
    } else {
        println("블록 2 수행")
        "10이 아닙니다."
    }
    println("a6 : $a6")
}