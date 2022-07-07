package kr.co.softcampus.checkedtextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckedTextView
import kr.co.softcampus.checkedtextview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val content = binding.textView
            content.text = ""
            // 체크박스
            if(binding.checkedTextView.isChecked) {
                content.append("첫 번째 체크 박스가 체크되어 있습니다\n")
            }
            else {
                content.append("첫 번째 체크 박스가 체크되어 있지 않습니다\n")
            }

            if(binding.checkedTextView2.isChecked) {
                content.append("두 번째 체크 박스가 체크되어 있습니다\n")
            }
            else {
                content.append("두 번째 체크 박스가 체크되어 있지 않습니다\n")
            }

            if(binding.checkedTextView3.isChecked) {
                content.append("세 번째 체크 박스가 체크되어 있습니다\n")
            }
            else {
                content.append("세 번째 체크 박스가 체크되어 있지 않습니다\n")
            }

            if(binding.checkedTextView4.isChecked) {
                content.append("첫 번째 라디오 버튼이 선택되어 있습니다\n")
            }
            else if(binding.checkedTextView5.isChecked) {
                content.append("두 번째 라디오 버튼이 선택되어 있습니다\n")
            }
            else if(binding.checkedTextView6.isChecked) {
                content.append("세 번째 라디오 버튼이 선택되어 있습니다\n")
            }

            binding.button2.setOnClickListener {
                binding.checkedTextView.isChecked = false
                binding.checkedTextView2.isChecked = true
                binding.checkedTextView3.isChecked = false

                binding.checkedTextView4.isChecked = true
                binding.checkedTextView5.isChecked = false
                binding.checkedTextView6.isChecked = false
            }
        }

        binding.checkedTextView.setOnClickListener(checkboxListener)
        binding.checkedTextView2.setOnClickListener(checkboxListener)
        binding.checkedTextView3.setOnClickListener(checkboxListener)

        binding.checkedTextView4.setOnClickListener(radioListener)
        binding.checkedTextView5.setOnClickListener(radioListener)
        binding.checkedTextView6.setOnClickListener(radioListener)
    }

    val checkboxListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            // 형변환
            val obj = v as CheckedTextView

            obj.toggle()
        }
    }

    val radioListener = object : View.OnClickListener {
        override fun onClick(v: View?) {
            binding.checkedTextView4.isChecked = false
            binding.checkedTextView5.isChecked = false
            binding.checkedTextView6.isChecked = false

            // 형변환
            val obj = v as CheckedTextView

            obj.isChecked = true
        }
    }
}