package kr.co.softcampus.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kr.co.softcampus.listview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val data1 = arrayOf(
        "문자열1", "문자열2", "문자열3", "문자열4", "문자열5",
        "문자열6", "문자열7", "문자열8", "문자열9", "문자열10",
        "문자열11", "문자열12", "문자열13", "문자열14", "문자열15",
        "문자열16", "문자열17", "문자열18", "문자열19", "문자열20",
        "문자열21", "문자열22", "문자열23", "문자열24", "문자열25"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 첫 번째 : Context
        // 두 번째 : 항목 하나를 구성하기 위해 사용할 Layout 파일
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, data1)
        binding.list1.adapter = adapter1

        binding.list1.setOnItemClickListener(listener1)
    }

    var listener1 = object : AdapterView.OnItemClickListener {
        // 첫 번째 : 이벤트가 발생한 항목을 가지고 있는 AdapterView
        // 두 번째 : 이벤트가 발생한 항목 View
        // 세 번째 : 이벤트가 발생한 항목의 index
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            when(parent?.id) {
                R.id.list1 -> {
                    binding.textView.text = "${data1[position]}을(를) 클릭했습니다"
                }
            }
        }
    }
}