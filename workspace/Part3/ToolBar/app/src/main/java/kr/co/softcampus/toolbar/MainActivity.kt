package kr.co.softcampus.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kr.co.softcampus.toolbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // toolbar를 액션바 대신 사용하도록 설정한다.
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item1 -> {
                binding.textView.text = "메뉴 1을 눌렀습니다"
            }
            R.id.item2 -> {
                binding.textView.text = "메뉴 2를 눌렀습니다"
            }
            R.id.item3 -> {
                binding.textView.text = "메뉴 3을 눌렀습니다"
            }
        }

        return super.onOptionsItemSelected(item)
    }
}