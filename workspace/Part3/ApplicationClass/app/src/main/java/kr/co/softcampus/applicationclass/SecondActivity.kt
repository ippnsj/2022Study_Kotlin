package kr.co.softcampus.applicationclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.applicationclass.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as AppClass

        with(binding) {
            textView2.text = "value1 : ${app.value1}\n"
            textView2.append("value2 : ${app.value2}")

            button2.setOnClickListener {
                app.value1 = 200
                app.value2 = "반갑습니다"
                setResult(RESULT_OK)
                finish()
            }
        }
    }
}