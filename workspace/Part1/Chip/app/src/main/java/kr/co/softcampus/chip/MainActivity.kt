package kr.co.softcampus.chip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.chip.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.chip1.setOnClickListener {
            binding.textView.text = "첫 번째 Chip을 클릭하였습니다\n"

            if(binding.chip2.isChecked) {
                binding.textView.append("두 번째 Chip이 선택되었습니다\n")
            }
            else {
                binding.textView.append("두 번째 Chip이 선택 되어 있지 않습니다\n")
            }

            if(binding.chip3.isChecked) {
                binding.textView.append("세 번째 Chip이 선택되었습니다\n")
            }
            else {
                binding.textView.append("세 번째 Chip이 선택 되어 있지 않습니다\n")
            }

            if(binding.chip4.isChecked) {
                binding.textView.append("네 번째 Chip이 선택되었습니다\n")
            }
            else {
                binding.textView.append("네 번째 Chip이 선택 되어 있지 않습니다\n")
            }

            when(binding.chipGroup1.checkedChipId) {
                R.id.chip5 -> {
                    binding.textView.append("그룹 내의 첫 번째 Chip이 선택되어 있습니다")
                }
                R.id.chip6 -> {
                    binding.textView.append("그룹 내의 두 번째 Chip이 선택되어 있습니다")
                }
                R.id.chip7 -> {
                    binding.textView.append("그룹 내의 세 번째 Chip이 선택되어 있습니다")
                }
            }
        }

        binding.chip3.setOnCloseIconClickListener { 
            binding.textView.text = "닫기 버튼을 눌렀습니다"
        }
        
        binding.chip4.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked) {
                binding.textView.text = "네 번째 Chip이 체크 되었습니다"
            }
            else {
                binding.textView.text = "네 번째 Chip이 체크 해제 되었습니다"
            }
        }
    }
}