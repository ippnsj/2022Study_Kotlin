package kr.co.softcampus.actionbarcustomizing

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.actionbarcustomizing.databinding.ActivityMainBinding
import kr.co.softcampus.actionbarcustomizing.databinding.CustomActionbarBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var topBarBinding: CustomActionbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayShowCustomEnabled(true)
        // 아래 세 개를 세팅해주지 않으면 custom actionbar가 나타나지 않는 안드로이드 버전도 있다.
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setDisplayShowHomeEnabled(false)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // layout을 통해 View를 생성한다.
        val topBar = layoutInflater.inflate(R.layout.custom_actionbar, null)
        supportActionBar?.customView = topBar

        topBarBinding = CustomActionbarBinding.bind(topBar)

        with(topBarBinding) {
            textView2.text = "커스텀 액션바"
            textView2.setTextColor(Color.WHITE)

            button.setOnClickListener {
                binding.textView.text = "액션바의 버튼을 눌렀습니다"
            }
        }
    }
}