package kr.co.softcampus.activityanimation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.activityanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
                // overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                // overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

                overridePendingTransition(R.anim.slide_xml1, R.anim.slide_xml2)
            }
        }
    }
}