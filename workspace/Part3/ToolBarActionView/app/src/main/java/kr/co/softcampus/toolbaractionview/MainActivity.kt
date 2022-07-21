package kr.co.softcampus.toolbaractionview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import kr.co.softcampus.toolbaractionview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val dataList = arrayOf("aaaa", "bbbb", "cccc", "aabb", "aacc")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList)
        binding.list1.adapter = adapter

        binding.list1.isTextFilterEnabled = true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        
        val item1 = menu?.findItem(R.id.item1)
        val search1 = item1?.actionView as SearchView
        search1.queryHint = "검색어 입력"

        // 액션뷰가 접혀지거나 펼쳐졌을 때 반응할 리스너
        val listener1 = object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionCollapse(p0: MenuItem?): Boolean {
                binding.textView.text = "접혀졌습니다"
                return true
            }

            override fun onMenuItemActionExpand(p0: MenuItem?): Boolean {
                binding.textView.text = "펼쳐졌습니다"
                return true
            }
        }

        item1.setOnActionExpandListener(listener1)

        // 입력과 관련된 리스너
        val listener2 = object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                binding.textView.text = "입력 중입니다"
                binding.textView2.text = "입력 중 : $newText"

                binding.list1.setFilterText(newText)
                if(newText?.length == 0) {
                    binding.list1.clearTextFilter()
                }
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.textView.text = "입력완료"
                binding.textView2.text = "입력 완료 : $query"
                search1.clearFocus()
                return true
            }
        }

        search1.setOnQueryTextListener(listener2)

        return true
    }
}