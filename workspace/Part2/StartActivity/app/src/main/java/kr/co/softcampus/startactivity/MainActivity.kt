package kr.co.softcampus.startactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.co.softcampus.startactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val second_intent = Intent(this, SecondActivity::class.java)
            startActivity(second_intent)
        }
    }

    override fun onPause() {
        super.onPause()
        Log.d("test", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("test", "onStop")
    }
}