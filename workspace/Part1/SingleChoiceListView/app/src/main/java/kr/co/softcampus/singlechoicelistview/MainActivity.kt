package kr.co.softcampus.singlechoicelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kr.co.softcampus.singlechoicelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5", "항목6", "항목7", "항목8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, data1)

        with(binding) {
            list1.adapter = adapter1
            list1.choiceMode = ListView.CHOICE_MODE_SINGLE
            list1.setItemChecked(2, true)

            button.setOnClickListener {
                textView.text = "${data1[list1.checkedItemPosition]} 항목이 선택되어 있습니다."
            }
        }
    }
}