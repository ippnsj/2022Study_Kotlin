fun main() {
//    val obj1 = TestClass()
//    println("obj1.a1 : ${obj1.a1}")
//    obj1.testFun1()
//
//    val obj2 = TestClass()
//    println("obj2.a1 : ${obj2.a1}")
//    obj1.testFun1()
//
//    obj1.a1 = 200
//    println("obj1.a1 : ${obj1.a1}")
//    println("obj2.a1 : ${obj2.a1}")
//
////     정적 멤버는 참조 변수로 접근이 불가능하다.
////     println("obj1.a2 : ${obj1.a2}")
////     obj1.testFun2()
//
//    println("TestClass.a2 : ${TestClass.a2}")
//    TestClass.testFun2()
//
//    val obj3 = JavaMain()
//    println("obj3.javaA1 : ${obj3.javaA1}")
//    obj3.javaMethod1()
//
//    println("JavaMain.javaA2 : ${JavaMain.javaA2}")
//    JavaMain.javaMethod2()

    val manager1 = SoundManager
    manager1.changeSound("papunica")
    manager1.play()

    manager1.stop()
    manager1.changeSound("faten")
    manager1.play()

    // val soundManager = SoundManagerASD()
    /*val soundManager2 = SoundManagerASD()

    var fatenSoundManager = SoundManagerASD("faten")
    var fatenSoundManager = SoundManagerASD("faten")
    var fatenSoundManager = SoundManagerASD("faten")
    var fatenSoundManager = SoundManagerASD("faten")
    var fatenSoundManager = SoundManagerASD("faten")
    var fatenSoundManager = SoundManagerASD("faten")

    papunicaSoundManager.Play()

    papunicaSoundManager.Stop()
    fatenSoundManager.Play()*/

}

class Singleton {
    var instance : Singleton? = null

    private constructor() {

    }

    fun createInstance() : Singleton? {
        if (instance == null) {
            instance = Singleton()
        }

        return instance
    }
}

class SoundManager{
    companion object {
        var playingSound = ""
        var playing = false

        fun changeSound(sound: String) {
            playingSound = sound
        }

        fun play() {
            playing = true
            while(playing) {
                Thread.sleep(1000L)
                println("Playing $playingSound in manager")
            }
        }

        fun stop() {
            playing = false

        }
    }
}

class SoundManagerASD(private val sound: String) {
    var playing = false

    fun Play() {
        playing = true
        while(playing) {
            Thread.sleep(1000L)
            println("Playing $sound in managerASD")
        }
    }

    fun Stop() {
        playing = false
    }
}

class TestClass{
    var a1:Int = 100

    companion object{
        var a2 = 1000
        @JvmStatic var a3 = 2000

        fun testFun2(){
            println("testFun2")
            // 객체 생성 여부를 보장받을 수 없으므로
            // 객체가 있어야지만 사용 가능한 외부 변수는 사용할 수 없다.
            // println("a1 : $a1")
            println("a2 : $a2")
        }

        @JvmStatic fun testFun3() {
            println("testFun3")
        }
    }

    fun testFun1(){
        println("testFun1")
        println("a1 : $a1")
        println("a2 : $a2")
        testFun2()
    }
}