package kr.co.softcampus.multichoicelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.util.forEach
import androidx.core.util.keyIterator
import kr.co.softcampus.multichoicelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val data1 = arrayOf(
        "항목1", "항목2", "항목3", "항목4",
        "항목5", "항목6", "항목7", "항목8"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, data1)

        with(binding) {
            list1.adapter = adapter1
            list1.choiceMode = ListView.CHOICE_MODE_MULTIPLE

            list1.setItemChecked(0, true)
            list1.setItemChecked(2, true)
            list1.setItemChecked(4, true)

            button.setOnClickListener {
                textView.text = ""
                // 현재 체크 상태에 관련된 객체를 가져온다 (현재 체크된 객체 + 체크 상태가 변경된 적이 있는 객체)
                val boolArray = list1.checkedItemPositions

                // textView.text = "개수 : ${boolArray.size()}"

                boolArray.forEach { key, value ->
                    // 해당 항목이 체크되어 있는지 확인한다.
                    if(value) {
                       textView.append("${data1[key]}, ")
                    }
                }
            }
        }
    }
}