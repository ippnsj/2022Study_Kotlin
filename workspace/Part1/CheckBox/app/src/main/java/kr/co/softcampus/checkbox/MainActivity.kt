package kr.co.softcampus.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kr.co.softcampus.checkbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var memo = binding.textView
            memo.text = ""

            if(binding.checkBox.isChecked) {
                memo.append("첫 번째 체크 박스는 체크되어 있습니다\n")
            }
            else {
                memo.append("첫 번째 체크 박스는 해제되어 있습니다\n")
            }

            if(binding.checkBox2.isChecked) {
                memo.append("두 번째 체크 박스는 체크되어 있습니다\n")
            }
            else {
                memo.append("두 번째 체크 박스는 해제되어 있습니다\n")
            }

            if(binding.checkBox3.isChecked) {
                memo.append("세 번째 체크 박스는 체크되어 있습니다")
            }
            else {
                memo.append("세 번째 체크 박스는 해제되어 있습니다")
            }
        }

        binding.button2.setOnClickListener{
            binding.checkBox.isChecked = true
            binding.checkBox2.isChecked = true
            binding.checkBox3.isChecked = true
        }

        binding.button3.setOnClickListener{
            binding.checkBox.isChecked = false
            binding.checkBox2.isChecked = false
            binding.checkBox3.isChecked = false
        }

        binding.button4.setOnClickListener {
            binding.checkBox.toggle()
            binding.checkBox2.toggle()
            binding.checkBox3.toggle()
        }

        binding.checkBox.setOnCheckedChangeListener(listener1)
        binding.checkBox2.setOnCheckedChangeListener(listener1)
        binding.checkBox3.setOnCheckedChangeListener { compoundButton, b ->
            if(b) {
                binding.textView.text = "세 번째 체크박스가 체크되었습니다"
            }
            else {
                binding.textView.text = "세 번째 체크박스가 해제되었습니다"
            }
        }
    }

    val listener1 = object : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            val memo = binding.textView
            when(p0?.id) {
                R.id.checkBox -> {
                    if(p1) {
                        memo.text = "첫 번째 체크박스가 체크되었습니다"
                    }
                    else {
                        memo.text = "첫 번째 체크박스가 해제되었습니다"
                    }
                }
                R.id.checkBox2 -> {
                    if(p1) {
                        memo.text = "두 번째 체크박스가 체크되었습니다"
                    }
                    else {
                        memo.text = "두 번째 체크박스가 해제되었습니다"
                    }
                }
            }
        }
    }
}