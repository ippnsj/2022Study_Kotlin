package kr.co.softcampus.radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import kr.co.softcampus.radiobutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.radioButton3.isChecked = true
            binding.radioButton6.isChecked = true
        }

        binding.button2.setOnClickListener {
            var status1 = binding.textView
            var status2 = binding.textView2
            when(binding.radioGroup1.checkedRadioButtonId) {
                R.id.radioButton -> {
                    status1.text = "라디오 1-1이 체크되어 있습니다"
                }
                R.id.radioButton2 -> {
                    status1.text = "라디오 1-2가 체크되어 있습니다"
                }
                R.id.radioButton3 -> {
                    status1.text = "라디오 1-3이 체크되어 있습니다"
                }
            }

            when(binding.radioGroup2.checkedRadioButtonId) {
                R.id.radioButton4 -> {
                    status2.text = "라디오 2-1이 체크되어 있습니다"
                }
                R.id.radioButton5 -> {
                    status2.text = "라디오 2-2가 체크되어 있습니다"
                }
                R.id.radioButton6 -> {
                    status2.text = "라디오 2-3이 체크되어 있습니다"
                }
            }
        }

        binding.radioGroup1.setOnCheckedChangeListener(listener1)
        binding.radioGroup2.setOnCheckedChangeListener { radioGroup, i ->
            var status = binding.textView2
            when(i) {
                R.id.radioButton4 -> {
                    status.text = "라디오 2-1이 체크되었습니다"
                }
                R.id.radioButton5 -> {
                    status.text = "라디오 2-2가 체크되었습니다"
                }
                R.id.radioButton6 -> {
                    status.text = "라디오 2-3이 체크되었습니다"
                }
            }
        }
    }

    val listener1 = object : RadioGroup.OnCheckedChangeListener {
        override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
            when(p0?.id) {
                R.id.radioGroup1 -> {
                    var status = binding.textView
                    when(p1) {
                        R.id.radioButton -> {
                            status.text = "라디오 1-1이 체크되었습니다"
                        }
                        R.id.radioButton2 -> {
                            status.text = "라디오 1-2가 체크되었습니다"
                        }
                        R.id.radioButton3 -> {
                            status.text = "라디오 1-3이 체크되었습니다"
                        }
                    }
                }
            }
        }
    }
}