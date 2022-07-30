package kr.co.softcampus.imageanimation

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.imageanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            // imageView.setImageResource(R.drawable.ani_data)
            // val drawable = getDrawable(R.drawable.ani_data)
            // imageView.setImageDrawable(drawable)

            // 애니메이션 객체를 추출한다.
            val ani = imageView.drawable as AnimationDrawable

            button.setOnClickListener {
                ani.start()
            }

            button2.setOnClickListener {
                ani.stop()
            }
        }
    }
}