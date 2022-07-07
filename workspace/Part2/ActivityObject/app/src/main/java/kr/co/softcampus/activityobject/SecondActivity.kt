package kr.co.softcampus.activityobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.activityobject.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val obj1 = intent.getParcelableExtra<TestClass>("obj1")

        binding.textView2.text = "obj1.data1 : ${obj1?.data1}\n"
        binding.textView2.append("obj1.data2 : ${obj1?.data2}")

        binding.button2.setOnClickListener {
            val t2 = TestClass()
            t2.data1 = 200
            t2.data2 = "문자열2"

            val result_intent = Intent()
            result_intent.putExtra("obj2", t2)

            setResult(RESULT_OK, result_intent)

            finish()
        }
    }
}