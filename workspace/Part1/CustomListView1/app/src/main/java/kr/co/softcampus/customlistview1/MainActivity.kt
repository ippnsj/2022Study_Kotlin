package kr.co.softcampus.customlistview1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kr.co.softcampus.customlistview1.databinding.ActivityMainBinding

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

        val adapter1 = ArrayAdapter(this, R.layout.row, R.id.rowTextView, data1)
        binding.list1.adapter = adapter1

        binding.list1.setOnItemClickListener { parent, view, position, id ->
            binding.textView.text = "${data1[position]}을(를) 터치하였습니다"
        }
    }
}