package kr.co.softcampus.resbasic

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.resbasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                // textView.text = "반갑습니다"
                // textView.setText(R.string.str2)
                // val str2 = resources.getString(R.string.str2)
                val str2 = getString(R.string.str2)
                textView.text = str2
            }

            button2.setOnClickListener {
                val str3 = getString(R.string.str3)
                val str4 = String.format(str3, "홍길동", 30)
                textView.text = str4
            }

            button3.setOnClickListener {
                val data_list = resources.getStringArray(R.array.data_array)

                textView.text = ""

                for(str in data_list) {
                    textView.append("$str\n")
                }
            }

            button4.setOnClickListener {
                // textView.setTextColor(Color.BLUE)
                // val color = Color.rgb(26, 106, 129)
                // val color = Color.argb(50, 26, 106, 129)
                // val color = getColor(R.color.color2)
                // val color = getColor(R.color.color3)
                val color = getColor(R.color.color4)
                textView.setTextColor(color)
            }

            button5.setOnClickListener {
                val px = resources.getDimension(R.dimen.px)
                val dp = resources.getDimension(R.dimen.dp)
                val sp = resources.getDimension(R.dimen.sp)
                val inch = resources.getDimension(R.dimen.inch)
                val mm = resources.getDimension(R.dimen.mm)
                val pt = resources.getDimension(R.dimen.pt)

                textView.text = "px : $px\n"
                textView.append("dp : $dp\n")
                textView.append("sp : $sp\n")
                textView.append("inch : $inch\n")
                textView.append("mm : $mm\n")
                textView.append("pt : $pt\n")

                textView.textSize = 20 * sp
            }
        }
    }
}