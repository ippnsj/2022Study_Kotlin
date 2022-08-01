package kr.co.softcampus.httpxml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.httpxml.databinding.ActivityMainBinding
import org.w3c.dom.Element
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.DocumentBuilderFactory
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
                    val site = "http://121.162.58.177:8080/xml.jsp"
                    val url = URL(site)
                    val conn = url.openConnection() as HttpURLConnection

                    // DOM 방식으로 XML 문서를 분석할 수 있는 객체를 생성한다.
                    val factory = DocumentBuilderFactory.newInstance()
                    val builder = factory.newDocumentBuilder()
                    val doc = builder.parse(conn.inputStream)

                    // 최상위 태그를 얻어온다.
                    val root = doc.documentElement
                    //item 태그들을 가져온다.
                    val item_list = root.getElementsByTagName("item")

                    runOnUiThread {
                        textView.text = ""
                    }

                    // item 태그의 수 만큼 반복한다.
                    for(i in 0 until item_list.length) {
                        // i 번째 item 태그 객체를 추출한다.
                        val item_tag = item_list.item(i) as Element
                        // item 태그안의 태그들을 얻어온다.
                        val data1_list = item_tag.getElementsByTagName("data1")
                        val data2_list = item_tag.getElementsByTagName("data2")
                        val data3_list = item_tag.getElementsByTagName("data3")

                        // 0 번째 태그를 가져온다.
                        val data1_tag = data1_list.item(0) as Element
                        val data2_tag = data2_list.item(0) as Element
                        val data3_tag = data3_list.item(0) as Element

                        // 태그 내의 문자열 테이터를 가져온다.
                        val data1 = data1_tag.textContent
                        val data2 = (data2_tag.textContent).toInt()
                        val data3 = (data3_tag.textContent).toDouble()

                        runOnUiThread {
                            textView.append("data1 : $data1\n")
                            textView.append("data2 : $data2\n")
                            textView.append("data3 : $data3\n\n")
                        }
                    }
                }
            }
        }
    }
}