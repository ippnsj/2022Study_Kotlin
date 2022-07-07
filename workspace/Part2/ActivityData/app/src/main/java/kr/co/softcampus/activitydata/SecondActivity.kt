package kr.co.softcampus.activitydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.activitydata.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 현재 Activity를 실행하기 위해 사용한 Intent로부터 데이터를 추출한다.
        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getDoubleExtra("data2", 0.0)
        val data3 = intent.getBooleanExtra("data3", false)
        val data4 = intent.getStringExtra("data4")

        binding.textView2.text = "data1 : $data1\n"
        binding.textView2.append("data2 : $data2\n")
        binding.textView2.append("data3 : $data3\n")
        binding.textView2.append("data4 : $data4")

        binding.button2.setOnClickListener {
            val result_intent = Intent()

            result_intent.putExtra("value1", 200)
            result_intent.putExtra("value2", 22.22)
            result_intent.putExtra("value3", false)
            result_intent.putExtra("value4", "문자열2")

            setResult(RESULT_OK, result_intent)

            finish()
        }
    }
}