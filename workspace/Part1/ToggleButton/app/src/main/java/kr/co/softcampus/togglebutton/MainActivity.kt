package kr.co.softcampus.togglebutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kr.co.softcampus.togglebutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if(binding.toggleButton.isChecked) {
                binding.textView.text = "ON 상태 입니다"
            }
            else {
                binding.textView.text = "OFF 상태 입니다"
            }
        }

        binding.button2.setOnClickListener {
            binding.toggleButton.isChecked = true
        }

        binding.button3.setOnClickListener {
            binding.toggleButton.isChecked = false
        }

        binding.button4.setOnClickListener {
            binding.toggleButton.toggle()
        }

        binding.toggleButton.setOnClickListener(listener)

        binding.toggleButton2.setOnClickListener {
            if(binding.toggleButton2.isChecked) {
                binding.textView2.text = "ON 상태로 설정되었습니다"
            }
            else {
                binding.textView2.text = "OFF 상태로 설정되었습니다"
            }
        }
    }

    val listener = object : View.OnClickListener {
        override fun onClick(p0: View?) {
            if(binding.toggleButton.isChecked) {
                binding.textView.text = "ON 상태로 설정되었습니다"
            }
            else {
                binding.textView.text = "OFF 상태로 설정되었습니다"
            }
        }
    }
}