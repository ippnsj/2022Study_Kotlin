package kr.co.softcampus.contextmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kr.co.softcampus.contextmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val data1 = listOf<String>(
        "항목1", "항목2", "항목3", "항목4", "항목5"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        binding.list1.adapter = adapter

        binding.list1.setOnItemClickListener { parent, view, position, id ->
            binding.textView.text = "리스트뷰의 항목 클릭 : ${data1[position]}"
        }

        // ContextMenu를 View에 등록한다.
        registerForContextMenu(binding.textView)
        registerForContextMenu(binding.list1)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)

        // 길게 누른 View의 id로 분기한다
        when(v?.id) {
            R.id.textView -> {
                menu?.setHeaderTitle("텍스트뷰의 메뉴")
                menuInflater.inflate(R.menu.menu1, menu)
            }
            R.id.list1 -> {
                // 사용자가 길게 누른 항목 인덱스 번호를 파악하기 위해...
                val info = menuInfo as AdapterView.AdapterContextMenuInfo

                menu?.setHeaderTitle("리스트뷰의 메뉴 : ${info.position}")
                menuInflater.inflate(R.menu.menu2, menu)
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        // 리스트 항목의 인덱스 번호를 받을 변수
        var position = 0
        when(item.itemId) {
            R.id.list_item1, R.id.list_item2 -> {
                // MenuInfo 객체를 추출한다.
                val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
                position = info.position
            }
        }

        // 메뉴의 id 값으로 분기한다.
        when(item.itemId) {
            R.id.text_item1 -> {
                binding.textView.text = "텍스트 뷰의 메뉴1을 눌렀습니다."
            }
            R.id.text_item2 -> {
                binding.textView.text = "텍스트 뷰의 메뉴2를 눌렀습니다."
            }
            R.id.list_item1 -> {
                binding.textView.text = "리스트 뷰의 메뉴1을 눌렀습니다. : $position"
            }
            R.id.list_item2 -> {
                binding.textView.text = "리스트 뷰의 메뉴2를 눌렀습니다. : $position"
            }
        }

        return super.onContextItemSelected(item)
    }
}