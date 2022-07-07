package kr.co.softcampus.activityobject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.co.softcampus.activityobject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var secondActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        secondActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK) {
                // 객체를 추출한다.
                val obj2 = result.data?.getParcelableExtra<TestClass>("obj2")

                binding.textView.text = "obj2.data1 : ${obj2?.data1}\n"
                binding.textView.append("obj2.data2 : ${obj2?.data2}")
            }
        }

        binding.button.setOnClickListener {
            val second_intent = Intent(this, SecondActivity::class.java)

            val t1 = TestClass()
            t1.data1 = 100
            t1.data2 = "문자열1"

            second_intent.putExtra("obj1", t1)

            // startActivity(second_intent)
            secondActivityResultLauncher.launch(second_intent)
        }
    }
}