package kr.co.softcampus.textview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kr.co.softcampus.textview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 뷰의 주소값을 얻어온다.
        val text1 = findViewById<TextView>(R.id.text1)
        text1.text = "안녕하세요"

        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        mainBinding.text2.text = "반갑습니다"

        mainBinding.text2.setBackgroundColor(Color.argb(100, 100, 100, 100))
        mainBinding.text2.setTextColor(Color.BLUE)
        mainBinding.text2.append("\n감사합니다")
    }
}