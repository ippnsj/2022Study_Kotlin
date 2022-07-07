package kr.co.softcampus.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import kr.co.softcampus.ratingbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var message = "Rating 1 : ${binding.ratingBar.rating}\n" +
                    "Rating 2 : ${binding.ratingBar2.rating}\n" +
                    "Rating 3 : ${binding.ratingBar3.rating}\n" +
                    "Rating 4 : ${binding.ratingBar4.rating}\n"
            binding.textView.text = message
        }

        binding.button2.setOnClickListener {
            binding.ratingBar.rating = 1.0f
            binding.ratingBar2.rating = 2.0f
            binding.ratingBar3.rating = 3.5f
            binding.ratingBar4.rating = 4.0f
        }

        binding.ratingBar2.setOnRatingBarChangeListener(listener1)
        binding.ratingBar3.setOnRatingBarChangeListener(listener1)

        binding.ratingBar4.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            var message = "Rating 3 : ${rating}\n"
            if(fromUser) {
                message += "사용자에 의해 설정되었습니다"
            }else {
                message += "코드를 통해 설정되었습니다"
            }
            binding.textView3.text = message
        }
    }

    val listener1 = object : RatingBar.OnRatingBarChangeListener {
        override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
            var message = ""

            when(ratingBar?.id) {
                R.id.ratingBar2 -> {
                    message = "Rating 2 : ${rating}\n"
                    if(fromUser) {
                        message += "사용자에 의해 설정되었습니다"
                    }else {
                        message += "코드를 통해 설정되었습니다"
                    }
                    binding.textView.text = message
                }
                R.id.ratingBar3 -> {
                    message = "Rating 3 : ${rating}\n"
                    if(fromUser) {
                        message += "사용자에 의해 설정되었습니다"
                    }else {
                        message += "코드를 통해 설정되었습니다"
                    }
                    binding.textView2.text = message
                }
            }
        }
    }
}