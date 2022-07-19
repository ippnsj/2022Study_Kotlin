package kr.co.softcampus.activityanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.activityanimation.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button2.setOnClickListener {
                finishActivity()
            }
        }
    }

    // Backbutton을 누르면 호출되는 메서드
    override fun onBackPressed() {
        finishActivity()
    }

    fun finishActivity() {
        finish()
        // overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        // overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

        overridePendingTransition(R.anim.slide_xml4, R.anim.slide_xml3)
    }
}