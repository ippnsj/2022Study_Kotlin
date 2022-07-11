package kr.co.softcampus.listdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.appcompat.app.AlertDialog
import kr.co.softcampus.listdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5", "항목6", "항목7", "항목8")

    val data2 = arrayOf("토고", "프랑스", "스위스", "스페인", "일본", "독일", "브라질", "대한민국")
    val data3 = intArrayOf(
        R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4,
        R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("리스트 다이얼로그")
            builder.setNegativeButton("취소", null)

            builder.setItems(data1) { dialogInterface: DialogInterface, i: Int ->
                binding.textView.text = "기본 리스트 다이얼로그 : ${data1[i]}"
            }

            builder.show()
        }

        binding.button2.setOnClickListener {
            val items = ArrayList<HashMap<String, Any?>>()

            for(idx in data2.indices) {
                val item = HashMap<String, Any?>()
                item["country"] = data2[idx]
                item["img"] = data3[idx]

                items.add(item)
            }

            val keys = arrayOf("country", "img")
            val ids = intArrayOf(R.id.custom_text, R.id.custom_image)

            val adapter = SimpleAdapter(this, items, R.layout.custom_list, keys, ids)

            val builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 리스트 다이얼로그")

            builder.setAdapter(adapter) { dialogInterface: DialogInterface, i: Int ->
                binding.textView.text = "커스텀 리스트 다이얼로그 : ${data2[i]}"
            }

            builder.setNegativeButton("취소", null)
            builder.show()
        }
    }
}