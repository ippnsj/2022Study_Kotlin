package kr.co.softcampus.multiautocompletetextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.MultiAutoCompleteTextView
import android.widget.TextView
import kr.co.softcampus.multiautocompletetextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val data = arrayOf(
        "abcd", "abca", "abcb", "abcc", "bbaa", "bbab", "bcab", "bdab"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, data)
        with(binding) {
            // 구분자
            multiAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
            multiAutoCompleteTextView.setAdapter(adapter1)

            button.setOnClickListener {
                // , 를 기준으로 문자열을 잘라낸다.
                val strArray = multiAutoCompleteTextView.text.split(",")

                textView.text = ""

                for(str in strArray) {
                    if(str.trim() != "") {
                        textView.append("${str.trim()}\n")
                    }
                }
            }

            multiAutoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
                textView2.text = "${(view as TextView).text} 항목을 선택하였습니다."
            }
        }
    }
}