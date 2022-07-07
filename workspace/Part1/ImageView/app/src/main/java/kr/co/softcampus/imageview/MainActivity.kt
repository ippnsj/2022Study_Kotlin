package kr.co.softcampus.imageview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.imageview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView3.setImageResource(R.drawable.linky_logo)
    }
}