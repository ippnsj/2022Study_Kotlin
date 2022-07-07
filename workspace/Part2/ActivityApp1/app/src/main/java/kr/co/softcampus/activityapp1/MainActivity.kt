package kr.co.softcampus.activityapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.co.softcampus.activityapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var testActivityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        testActivityResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK) {
                val value1 = result.data?.getIntExtra("value1", 0)
                val value2 = result.data?.getStringExtra("value2")

                binding.textView.text = "value1 : $value1\n"
                binding.textView.append("value2 : $value2")
            }
        }

        binding.button.setOnClickListener {
            val test_intent = Intent("kr.co.softcampus.test_activity")

            test_intent.putExtra("data1", 100)
            test_intent.putExtra("data2", "문자열1")

            // startActivity(test_intent)
            testActivityResultLauncher.launch(test_intent)
        }
    }
}