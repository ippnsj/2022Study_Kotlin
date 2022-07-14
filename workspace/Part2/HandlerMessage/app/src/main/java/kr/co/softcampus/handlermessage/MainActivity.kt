package kr.co.softcampus.handlermessage

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import kr.co.softcampus.handlermessage.databinding.ActivityMainBinding
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

        // 화면 처리를 위한 핸들러
        val handler1 = object : Handler(Looper.myLooper()!!) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)

                when(msg.what) {
                    0 -> {
                        binding.textView2.text = "Handler 0"
                    }
                    1 -> {
                        binding.textView2.text = "Handler 1"
                    }
                    2 -> {
                        binding.textView2.text = "Handler 2 : ${msg.arg1}, ${msg.arg2}, ${msg.obj}"
                    }
                }
            }
        }

        // 오래 걸리는 작업 : Thread 발생
        isRunning = true
        thread {
            while(isRunning) {
                val now2 = System.currentTimeMillis()
                Log.d("test", "오래 걸리는 작업 : $now2")
                SystemClock.sleep(500)

                handler1.sendEmptyMessage(0)

                SystemClock.sleep(500)
                handler1.sendEmptyMessage(1)

                SystemClock.sleep(500)
                val msg = Message()
                msg.what = 2
                msg.arg1 = 100
                msg.arg2 = 200
                msg.obj = "객체"
                handler1.sendMessage(msg)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}