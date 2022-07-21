package kr.co.softcampus.toolbarnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.toolbarnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        with(binding) {
            button.setOnClickListener {
                val secondIntent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(secondIntent)
            }
        }
    }
}