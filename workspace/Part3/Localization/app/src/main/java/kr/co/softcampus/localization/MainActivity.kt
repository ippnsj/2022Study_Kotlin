package kr.co.softcampus.localization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.localization.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val str2 = getString(R.string.str1)
            textView2.text = str2
        }
    }
}