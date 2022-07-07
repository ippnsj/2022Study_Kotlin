package kr.co.softcampus.startactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.startactivity.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            finish()
        }
    }
}