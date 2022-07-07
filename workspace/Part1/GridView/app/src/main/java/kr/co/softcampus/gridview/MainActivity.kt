package kr.co.softcampus.gridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kr.co.softcampus.gridview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val data1 = arrayOf(
        "그리드1", "그리드2", "그리드3", "그리드4", "그리드5",
        "그리드6", "그리드7", "그리드8", "그리드9", "그리드10"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)

        binding.grid1.adapter = adapter1

        // binding.grid1.setOnItemClickListener(listener1)
        binding.grid1.setOnItemClickListener { parent, view, position, id ->
            binding.textView.text = "${data1[position]} 항목을 클릭하였습니다."
        }
    }

    val listener1 = object : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(parent?.id) {
                R.id.grid1 -> {
                    binding.textView.text = "${data1[position]} 항목을 클릭하였습니다."
                }
            }
        }
    }
}