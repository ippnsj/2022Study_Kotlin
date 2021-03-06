package kr.co.softcampus.pendingintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.pendingintent.databinding.ActivityNotification1Binding

class NotificationActivity1 : AppCompatActivity() {
    private lateinit var binding : ActivityNotification1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotification1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Activity를 실행했을 때 사용한 Intent를 통해 데이터를 추출한다.
        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getIntExtra("data2", 0)

        binding.textView.text = "data1 : $data1\n"
        binding.textView.append("data2 : $data2")
    }
}