package kr.co.softcampus.onactivityresult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.onactivityresult.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding : ActivityThirdBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.button5.setOnClickListener {
            setResult(RESULT_CANCELED, intent)
            finish()
        }

        binding.button6.setOnClickListener {
            setResult(RESULT_FIRST_USER, intent)
            finish()
        }

        binding.button7.setOnClickListener {
            setResult(RESULT_FIRST_USER + 1, intent)
            finish()
        }
    }
}