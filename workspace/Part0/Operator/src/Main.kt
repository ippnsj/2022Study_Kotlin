fun main() {
    // 단항 연산자 : 항이 하나인 연산자

    // + : 양수 -> 양수, 음수 -> 음수
    val a1 = 10
    val a2 = -10

    val r1 = +a1
    val r2 = +a2
    println("a1 : $a1, r1 : $r1")
    println("a2 : $a2, r2 : $r2")

    // - : 양수 -> 음수, 음수 -> 양수
    val r3 = -a1
    val r4 = -a2
    println("a1 : $a1, r3 : $r3")
    println("a2 : $a2, r4 : $r4")

    // ! : true -> false, false -> true
    val a3 = true
    val a4 = false

    val r5 = !a3
    val r6 = !a4
    println("a3 : $a3, r5 : $r5")
    println("a4 : $a4, r6 : $r6")

    println("---------------------------")

    var a5 = 10
    var a6 = 10
    val r7 = a5++ // val은 불가능하다.
    val r8 = a6-- // val은 불가능하다.
    println("a5 : $a5, r7: $r7")
    println("a6 : $a6, r8: $r8")

    var a7 = 10
    var a8 = 10
    val r9 = ++a7 // val은 불가능하다.
    val r10 = --a8 // val은 불가능하다.
    println("a7 : $a7, r9: $r9")
    println("a8 : $a8, r10: $r10")

    println("---------------------------")

    val r11 = 10 + 3
    val r12 = 10 - 3
    val r13 = 10 * 3
    val r14 = 10 / 3
    val r15 = 10 % 3
    println("$r11, $r12, $r13, $r14, $r15")

    val r16 = 10..20
    println("r16 : $r16")

    println("---------------------------")

    var a9 = 10
    var a10 = 10
    var a11 = 10
    var a12 = 10
    var a13 = 10
    a9 += 3
    a10 -= 3
    a11 *= 3
    a12 /= 3
    a13 %= 3
    println("$a9, $a10, $a11, $a12, $a13")

    println("---------------------------")

    val a14 = 10

    val r17 = a14 == 10
    val r18 = a14 != 10

    println("$r17, $r18")

    val r19 = a14 == 20
    val r20 = a14 != 20

    println("$r19, $r20")

    println("---------------------------")

    val a15 = 10

    val r21 = a15 < 20
    val r22 = a15 > 20
    val r23 = a15 <= 20
    val r24 = a15 >= 20
    println("$r21, $r22, $r23, $r24")
}