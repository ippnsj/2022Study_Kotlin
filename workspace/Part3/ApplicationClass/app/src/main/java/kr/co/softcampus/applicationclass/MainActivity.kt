package kr.co.softcampus.applicationclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.co.softcampus.applicationclass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var resultLauncherForSecondActivity : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as AppClass

        resultLauncherForSecondActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
                if(result.resultCode == RESULT_OK) {
                    binding.textView.text = "value1 : ${app.value1}\n"
                    binding.textView.append("value2 : ${app.value2}")
                }
            }

        with(binding) {
            button.setOnClickListener {
                app.method1()
                app.value1 = 100
                app.value2 = "안녕하세요"

                val secondIntent = Intent(this@MainActivity, SecondActivity::class.java)
                // startActivity(secondIntent)
                resultLauncherForSecondActivity.launch(secondIntent)
            }
        }
    }
}