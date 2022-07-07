package kr.co.softcampus.onactivityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.co.softcampus.onactivityresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var resultLauncherForSecondActivity : ActivityResultLauncher<Intent>
    private lateinit var resultLauncherForThirdActivity : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultLauncherForSecondActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK) {
                binding.textView.text = "SecondActivity에서 돌아왔습니다"
            }
        }

        resultLauncherForThirdActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            binding.textView.text = "ThirdActivity에서 돌아왔습니다.\n"
            when(result.resultCode) {
                RESULT_OK -> {
                    binding.textView.append("결과 : OK")
                }
                RESULT_CANCELED -> {
                    binding.textView.append("결과 : CANCELED")
                }
                RESULT_FIRST_USER -> {
                    binding.textView.append("결과 : USER 1")
                }
                RESULT_FIRST_USER + 1 -> {
                    binding.textView.append("결과 : USER 2")
                }
            }
        }

        binding.button.setOnClickListener {
            binding.textView.text = "MainActivity"
            val second_intent = Intent(this, SecondActivity::class.java)
//            startActivity(second_intent)
            resultLauncherForSecondActivity.launch(second_intent)
        }

        binding.button4.setOnClickListener {
            binding.textView.text = "MainActivity"
            val third_intent = Intent(this, ThirdActivity::class.java)
            resultLauncherForThirdActivity.launch(third_intent)
        }
    }
}