package kr.co.softcampus.assets

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.assets.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                val inputStream = assets.open("Text/data1.txt")
                val isr = InputStreamReader(inputStream, "UTF-8")
                val br = BufferedReader(isr)

                var str:String? = null
                val sb = StringBuffer()

                do {
                    str = br.readLine()
                    if(str != null) {
                        sb.append("$str\n")
                    }
                }while(str != null)

                br.close()

                textView.text = sb.toString()
            }

            button2.setOnClickListener {
                val inputStream = assets.open("Text/data2.txt")
                val isr = InputStreamReader(inputStream, "UTF-8")
                val br = BufferedReader(isr)

                var str:String? = null
                val sb = StringBuffer()

                do {
                    str = br.readLine()
                    if(str != null) {
                        sb.append("$str\n")
                    }
                }while(str != null)

                br.close()

                textView.text = sb.toString()
            }

            button3.setOnClickListener {
                // 폰트 객체를 만든다.
                val face = Typeface.createFromAsset(assets, "Font/HiMelody-Regular.ttf")
                textView.typeface = face
            }
        }
    }
}