// Handler는 개발자가 안드로이드 OS에게 작업 수행을 요청하는 역할을 한다.
// 개발자가 작업을 요청하면 안드로이드 OS는 작업을 하지 않을 때 개발자가 요청한 작업을 처리하게 된다.
// 이 처리는 Main Thread에서 처리한다.
// 5초 이상 걸리는 작업은 피하는 것이 좋다.
// 화면 처리도 가능하다.

package kr.co.softcampus.handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import kr.co.softcampus.handler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
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
            binding.textView2.text = "while문 : $now2"
        }*/

        val handler = Handler(Looper.myLooper()!!)

        // 처리 한번에 대한 작업을 구현해준다.
        // Thread를 상속받아서 만들었지만 내부 코드는 Main Thread에 의해 실행된다.
        // Main Thread가 실행하기 때문에 작업 한 번이 5초 이상을 필요로하는 작업이어서는 안 된다.
        val thread1 = object : Thread() {
            override fun run() {
                super.run()
                val now2 = System.currentTimeMillis()
                binding.textView2.text = "handler : $now2"

                // handler.post(this)
                handler.postDelayed(this, 100)
            }
        }

        // handler.post(thread1)
        handler.postDelayed(thread1, 100)
    }
}