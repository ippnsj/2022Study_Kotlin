fun main() {
    testMethod1("안녕하세요")
    testMethod1(null)

    println("-----------------------------")

    testMethod2("안녕하세요")
    testMethod2(null)
}

fun testMethod1(str:String?) {
    println(str?.length)

    if(str is String) {
        // 스마트 캐스팅 발생
        println(str.length)
    }

    if(str != null) {
        // 스마트 캐스팅 발생
        println(str.length)
    }

    // println(str.length)
}

fun testMethod2(str:Any?) {
    if(str is String) {
        println(str.length)
    }

    // 비교연산자보다는 is를 사용하는 것이 스마트 캐스팅에 좋다.
    /*if(str != null) {
        // null이 아닌건 확인되었지만 String 타입인지는 확인이 되지 않았다.
        println(str.length)
    }*/
}