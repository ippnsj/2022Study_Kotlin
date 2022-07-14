package kr.co.softcampus.runonuithread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import kr.co.softcampus.runonuithread.databinding.ActivityMainBinding
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

        isRunning = true

        thread {
            while(isRunning) {
                SystemClock.sleep(500)
                val now2 = System.currentTimeMillis()
                Log.d("test", "thread : $now2")

                /*runOnUiThread(object : Thread() {
                    override fun run() {
                        super.run()
                        binding.textView2.text = "runOnUiThread : $now2"
                    }
                })*/
                runOnUiThread {
                    binding.textView2.text = "runOnUiThread : $now2"
                }

                SystemClock.sleep(500)

                /*runOnUiThread(object : Thread() {
                    override fun run() {
                        super.run()
                        binding.textView2.text = "또 다른 작업"
                    }
                })*/
                
                runOnUiThread { 
                    binding.textView2.text = "또 다른 작업"
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        isRunning = false
    }
}