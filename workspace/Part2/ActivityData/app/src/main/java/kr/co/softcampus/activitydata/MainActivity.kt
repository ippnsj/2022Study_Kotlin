package kr.co.softcampus.activitydata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.co.softcampus.activitydata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var resultLauncherForSecondActivity: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultLauncherForSecondActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK) {
                val value1 = result.data?.getIntExtra("value1", 0)
                val value2 = result.data?.getDoubleExtra("value2", 0.0)
                val value3 = result.data?.getBooleanExtra("value3", false)
                val value4 = result.data?.getStringExtra("value4")

                binding.textView.text = "value1 : $value1\n"
                binding.textView.append("value2 : $value2\n")
                binding.textView.append("value3 : $value3\n")
                binding.textView.append("value4 : $value4")
            }
        }

        binding.button.setOnClickListener {
            val second_intent = Intent(this, SecondActivity::class.java)

            second_intent.putExtra("data1", 100)
            second_intent.putExtra("data2", 11.11)
            second_intent.putExtra("data3", true)
            second_intent.putExtra("data4", "문자열1")

            // startActivity(second_intent)
            resultLauncherForSecondActivity.launch(second_intent)
        }
    }
}