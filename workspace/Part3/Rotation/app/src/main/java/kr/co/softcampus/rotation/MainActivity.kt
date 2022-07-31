package kr.co.softcampus.rotation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kr.co.softcampus.rotation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Log.d("test", "$savedInstanceState")
        if(savedInstanceState == null) {
            Log.d("test", "Activity가 처음 등장하였습니다")
        }
        else {
            Log.d("test", "화면 회전이 발생했습니다")
            // 복원한다.
            binding.textView.text = savedInstanceState.getString("data1")
        }

        with(binding) {
            button.setOnClickListener {
                textView.text = editTextTextPersonName.text
            }
        }
    }

    // 화면 회전 발생 시 호출되는 메서드
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // 복원이 필요한 데이터를 저장한다.
        outState.putString("data1", binding.textView.text.toString())
    }
}