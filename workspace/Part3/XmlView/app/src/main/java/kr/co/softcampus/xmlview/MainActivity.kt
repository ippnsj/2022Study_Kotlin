package kr.co.softcampus.xmlview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.xmlview.databinding.ActivityMainBinding
import kr.co.softcampus.xmlview.databinding.LayoutSub1Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var subBinding : LayoutSub1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // View 객체를 생성한다.
        val sub1 = layoutInflater.inflate(R.layout.layout_sub1, null)
        val sub2 = layoutInflater.inflate(R.layout.layout_sub2, null)
        // 처음에 Activity가 나타나자마자 보여줄 화면을 구성하는 용도로 사용한다.
        // removeView가 불가능하다.
        val sub3 = layoutInflater.inflate(R.layout.layout_sub3, binding.container)

        subBinding = LayoutSub1Binding.bind(sub1)
        
        with(binding) {
            button.setOnClickListener {
                container.addView(sub1)
                container.addView(sub2)
            }

            button2.setOnClickListener {
                container.removeView(sub1)
                container.removeView(sub2)
                container.removeView(sub3)
            }

            subBinding.sub1Btn.setOnClickListener {
                subBinding.sub1Text.text = "sub1의 버튼을 눌렀습니다"
                textView.text = "sub1의 버튼을 눌렀습니다"
            }
        }
    }
}