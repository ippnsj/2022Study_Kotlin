// 화면에 관련된 작업이나 터치 처리는 UI Thread(Main Thread)에서만 처리 가능
// Main Thread가 바쁘다면 화면 작업이나 터치 처리를 할 수가 없다.
// 그러므로, 오래 걸리는 작업은 별도의 Thread 운영을 해야 한다.

package kr.co.softcampus.thread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kr.co.softcampus.thread.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var isRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val now = System.currentTimeMillis()
            binding.textView.text = "버튼 클릭 : $now"
        }

        /*while(true) {
            SystemClock.sleep(100)
            val now2 = System.currentTimeMillis()
            Log.d("test", "while문 : $now2")
        }*/

        isRunning = true

        /*val thread1 = object : Thread() {
            override fun run() {
                super.run()

                while(isRunning) {
                    SystemClock.sleep(100)
                    val now2 = System.currentTimeMillis()
                    Log.d("test", "Thread : $now2")
                    // 안드로이드 8.0 미만 버전에서는 (안드로이드 오레오 버전 미만에서는)
                    // Main Thread가 아닌 thread에서 아래와 같은 화면과 관련된 코드를 실행하면 오류가 발생한다.
                    // binding.textView2.text = "Thread : $now2"
                }
            }
        }
        thread1.start()*/

        thread {
            while(isRunning) {
                SystemClock.sleep(100)
                val now2 = System.currentTimeMillis()
                Log.d("test", "Thread : $now2")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}