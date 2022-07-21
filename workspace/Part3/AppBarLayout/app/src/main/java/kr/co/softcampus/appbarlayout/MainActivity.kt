package kr.co.softcampus.appbarlayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import kr.co.softcampus.appbarlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            setSupportActionBar(toolbar)

            toolbarLayout.setCollapsedTitleTextColor(Color.WHITE)
            toolbarLayout.setExpandedTitleColor(Color.GREEN)

            toolbarLayout.collapsedTitleGravity = Gravity.CENTER_HORIZONTAL
            toolbarLayout.expandedTitleGravity = Gravity.RIGHT + Gravity.TOP

            imageView.setImageResource(R.drawable.test_img)

            supportActionBar?.title = "Goose Goose Duck"
        }
    }
}