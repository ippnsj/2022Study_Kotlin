package kr.co.softcampus.actionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kr.co.softcampus.actionbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item1 -> {
                binding.textView.text = "첫 번째 메뉴"
            }
            R.id.item2 -> {
                binding.textView.text = "두 번째 메뉴"
            }
            R.id.item3 -> {
                binding.textView.text = "세 번째 메뉴"
            }
            R.id.item4 -> {
                binding.textView.text = "네 번째 메뉴"
            }
        }

        return super.onOptionsItemSelected(item)
    }
}