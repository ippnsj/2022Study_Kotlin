package kr.co.softcampus.activityapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.activityapp3.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data1 = intent.getIntExtra("data1", 0)
        val data2 = intent.getStringExtra("data2")

        binding.textView.text = "data1 : $data1\n"
        binding.textView.append("data2 : $data2")

        binding.button.setOnClickListener {
            val result_intent = Intent()
            result_intent.putExtra("value1", 300)
            result_intent.putExtra("value2", "문자열3")

            setResult(RESULT_OK, result_intent)

            finish()
        }
    }
}