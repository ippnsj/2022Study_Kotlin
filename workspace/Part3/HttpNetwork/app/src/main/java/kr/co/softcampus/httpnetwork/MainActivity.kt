package kr.co.softcampus.httpnetwork

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.httpnetwork.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                thread {
                    // 접속할 주소
                    val site = "http://121.162.58.177:8080/basic.jsp"
                    val url = URL(site)

                    // 접속
                    val conn = url.openConnection() as HttpURLConnection
                    
                    val isr = InputStreamReader(conn.inputStream, "UTF-8")
                    val br = BufferedReader(isr)

                    var str:String? = null
                    val buf = StringBuffer()

                    do {
                        str = br.readLine()
                        if(str != null) {
                            buf.append("$str\n")
                        }
                    }while (str != null)

                    runOnUiThread {
                        binding.textView.text = buf.toString()
                    }
                }
            }
        }
    }
}