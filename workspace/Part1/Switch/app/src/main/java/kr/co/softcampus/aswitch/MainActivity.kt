package kr.co.softcampus.aswitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import kr.co.softcampus.aswitch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if(binding.switch1.isChecked) {
                binding.textView.text = "ON 상태입니다"
            }
            else {
                binding.textView.text = "OFF 상태입니다"
            }
        }

        binding.button2.setOnClickListener {
            binding.switch1.isChecked = true
        }
        binding.button3.setOnClickListener {
            binding.switch1.isChecked = false
        }

        binding.switch1.setOnCheckedChangeListener(listener1)
        binding.switch2.setOnCheckedChangeListener { compoundButton, b ->
            var status = binding.textView2
            if(b) {
                status.text = "두 번째 스위치가 ON 상태가 되었습니다"
            }
            else {
                status.text = "두 번째 스위치가 OFF 상태가 되었습니다"
            }
        }
    }

    val listener1 = object : CompoundButton.OnCheckedChangeListener {
        override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
            when(p0?.id) {
                R.id.switch1 -> {
                    var status = binding.textView
                    if(p1) {
                        status.text = "첫 번째 스위치가 ON 상태가 되었습니다"
                    }
                    else {
                        status.text = "첫 번째 스위치가 OFF 상태가 되었습니다"
                    }
                }
            }
        }
    }
}