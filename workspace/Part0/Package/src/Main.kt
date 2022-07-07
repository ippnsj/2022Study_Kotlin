import kr.co.softcampus.pkg1.TestClass2
import kr.co.softcampus.pkg1.TestClass1
import kr.co.softcampus.pkg1.testFunction1
import kr.co.softcampus.pkg1.testFunction2
import kr.co.softcampus.pkg2.*

fun main() {
    val obj1: TestClass1 = TestClass1()
    obj1.testMethod1()

    testFunction1()

    val obj2 = TestClass2()
    obj2.testMethod2()

    testFunction2()

    val obj3 = TestClass3()
    val obj4 = TestClass4()
    obj3.testMethod3()
    obj4.testMethod4()
}