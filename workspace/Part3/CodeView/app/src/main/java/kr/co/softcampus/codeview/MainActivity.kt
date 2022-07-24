package kr.co.softcampus.codeview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import kr.co.softcampus.codeview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val param1 = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )

        val btn1 = Button(this)
        btn1.text = "추가된 버튼입니다"
        btn1.layoutParams = param1
        btn1.setOnClickListener {
            binding.textView.text = "추가된 버튼을 눌렀습니다"
        }

        val img1 = ImageView(this)
        img1.layoutParams = param1
        img1.setImageResource(R.mipmap.ic_launcher)

        binding.button.setOnClickListener {
            binding.container.addView(btn1)
            binding.container.addView(img1)
        }

        binding.button2.setOnClickListener {
            binding.container.removeView(btn1)
            binding.container.removeView(img1)
        }
    }
}