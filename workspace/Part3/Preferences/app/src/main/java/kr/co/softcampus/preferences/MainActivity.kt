package kr.co.softcampus.preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.preferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                // Preferences 객체를 추출한다.
                val pref = getSharedPreferences("data", Context.MODE_PRIVATE)

                // 데이터 저장을 위한 객체를 추출한다.
                val editor = pref.edit()

                editor.putBoolean("data1", true)
                editor.putFloat("data2", 11.11f)
                editor.putInt("data3", 100)
                editor.putLong("data4", 10000L)
                editor.putString("data5", "문자열 데이터")

                val set = HashSet<String>()
                set.add("문자열 1")
                set.add("문자열 2")
                set.add("문자열 3")
                editor.putStringSet("data6", set)

                editor.commit()

                textView.text = "저장완료"
            }

            button2.setOnClickListener {
                val pref = getSharedPreferences("data", Context.MODE_PRIVATE)

                // 저장된 데이터를 가져온다.
                val data1 = pref.getBoolean("data1", false)
                val data2 = pref.getFloat("data2", 0.0f)
                val data3 = pref.getInt("data3", 0)
                val data4 = pref.getLong("data4", 0L)
                val data5 = pref.getString("data5", "초기값")
                val data6 = pref.getStringSet("data6", null)

                textView.text = "data1 : $data1\n"
                textView.append("data2 : $data2\n")
                textView.append("data3 : $data3\n")
                textView.append("data4 : $data4\n")
                textView.append("data5 : $data5\n")

                for(str in data6!!) {
                    textView.append("data6 : $str\n")
                }
            }
        }
    }
}