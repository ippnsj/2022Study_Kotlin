// EditText에 hint, 글자수 count, error 등의 몇 가지 기능을 추가한 뷰이다.

package kr.co.softcampus.textinputlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputMethodManager
import kr.co.softcampus.textinputlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            binding.textView1.text = binding.textInputLayout1.editText?.text

            binding.textInputLayout1.editText?.clearFocus()
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(binding.textInputLayout1.editText?.windowToken, 0)
        }

        binding.textInputLayout1.editText?.addTextChangedListener(watcher1)
    }

    val watcher1 = object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
            if(p0 != null && p0.length > 10) {
                binding.textInputLayout1.error = "10글자 이하로 입력해주세요."
            }
            else {
                binding.textInputLayout1.error = null
            }
        }
    }
}