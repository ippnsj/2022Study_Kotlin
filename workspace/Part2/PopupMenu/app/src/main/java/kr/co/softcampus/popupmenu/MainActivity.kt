package kr.co.softcampus.popupmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import kr.co.softcampus.popupmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // PopupMenu 객체를 생성한다.
            val pop = PopupMenu(this, binding.textView)

            // 메뉴를 구성한다.
            menuInflater.inflate(R.menu.menu1, pop.menu)

            pop.setOnMenuItemClickListener {
                when(it.itemId) {
                    R.id.item1 -> {
                        binding.textView.text = "메뉴 1을 눌렀습니다."
                    }
                    R.id.item2 -> {
                        binding.textView.text = "메뉴 2를 눌렀습니다."
                    }
                    R.id.item3 -> {
                        binding.textView.text = "메뉴 3을 눌렀습니다."
                    }
                }

                true
            }

            pop.show()
        }
    }
}