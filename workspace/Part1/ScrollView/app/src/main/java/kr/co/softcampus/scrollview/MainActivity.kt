package kr.co.softcampus.scrollview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.co.softcampus.scrollview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.textView.text = "Y : ${binding.scroll1.scrollY}"
            binding.textView2.text = "X : ${binding.scroll2.scrollX}"
        }

        binding.button2.setOnClickListener {
//            지정된 위치로 애니메이션 없이 이동
//            binding.scroll1.scrollTo(0, 1000)
//            binding.scroll2.scrollTo(1000, 0)

//            지정된 위치로 애니메이션과 함께 이동
//            binding.scroll1.smoothScrollTo(0, 1000)
//            binding.scroll2.smoothScrollTo(1000, 0)

//            현재 위치에서 지정된 만큼 애니메이션과 함께 이동
            binding.scroll1.smoothScrollBy(0, 1000)
            binding.scroll2.smoothScrollBy(1000, 0)
        }

        binding.scroll1.setOnScrollChangeListener(listener1)
        binding.scroll2.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            binding.textView2.text = "X : ${oldScrollX} -> ${scrollX}"
        }
    }

    val listener1 = object : View.OnScrollChangeListener {
        override fun onScrollChange(
            v: View?,
            scrollX: Int,
            scrollY: Int,
            oldScrollX: Int,
            oldScrollY: Int
        ) {
            when(v?.id) {
                R.id.scroll1 -> {
                    binding.textView.text = "Y : ${oldScrollY} -> ${scrollY}"
                }
            }
        }
    }
}