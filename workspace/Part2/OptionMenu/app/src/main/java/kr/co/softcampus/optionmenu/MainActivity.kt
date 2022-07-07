package kr.co.softcampus.optionmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kr.co.softcampus.optionmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // XML로 메뉴를 구성한다.
//        menuInflater.inflate(R.menu.main_menu, menu)

        // groupId, id, 배치 순서, 이름
        menu?.add(Menu.NONE, Menu.FIRST, Menu.NONE, "코드 메뉴1")
//        menu?.add(Menu.NONE, Menu.FIRST + 1, Menu.NONE, "코드 메뉴2")
        val sub = menu?.addSubMenu("코드 메뉴2")
        sub?.add(Menu.NONE, Menu.FIRST + 10, Menu.NONE, "코드 메뉴2-1")
        sub?.add(Menu.NONE, Menu.FIRST + 20, Menu.NONE, "코드 메뉴2-2")
        menu?.add(Menu.NONE, Menu.FIRST + 2, Menu.NONE, "코드 메뉴3")

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // 메뉴의 id 별로 분기한다.
//        when(item.itemId) {
//            R.id.item1 -> {
//                binding.textView.text = "메뉴1을 눌렀습니다."
//            }
////            R.id.item2 -> {
////                binding.textView.text = "메뉴2를 눌렀습니다."
////            }
//            R.id.item2_1 -> {
//                binding.textView.text = "메뉴2-1을 눌렀습니다."
//            }
//            R.id.item2_2 -> {
//                binding.textView.text = "메뉴2-2를 눌렀습니다."
//            }
//            R.id.item3 -> {
//                binding.textView.text = "메뉴3을 눌렀습니다."
//            }
//        }
        when(item.itemId) {
            Menu.FIRST -> {
                binding.textView.text = "코드 메뉴1을 눌렀습니다."
            }
            Menu.FIRST + 10 -> {
                binding.textView.text = "코드 메뉴2-1을 눌렀습니다."
            }
            Menu.FIRST + 20 -> {
                binding.textView.text = "코드 메뉴2-2를 눌렀습니다."
            }
            Menu.FIRST + 2 -> {
                binding.textView.text = "코드 메뉴3을 눌렀습니다."
            }
        }

        return super.onOptionsItemSelected(item)
    }
}