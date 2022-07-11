package kr.co.softcampus.choicelistdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.util.forEach
import kr.co.softcampus.choicelistdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val data1 = arrayOf(
        "항목1", "항목2", "항목3", "항목4",
        "항목5", "항목6", "항목7", "항목8"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Single Choice List")

            builder.setSingleChoiceItems(data1, 3) { dialogInterface: DialogInterface, i: Int ->
                val toast = Toast.makeText(this, data1[i], Toast.LENGTH_SHORT)
                toast.show()
            }

            builder.setNegativeButton("취소", null)
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                val alert = dialogInterface as AlertDialog

                val idx = alert.listView.checkedItemPosition

                binding.textView.text = "선택된 항목 : ${data1[idx]}"
            }

            builder.show()
        }

        binding.button2.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            val boolArray = booleanArrayOf(true, false, false, true, false, false, false, false)

            builder.setMultiChoiceItems(data1, boolArray) { dialogInterface: DialogInterface, i: Int, b: Boolean ->
                if(b) {
                    val toast = Toast.makeText(this, "${data1[i]}가 체크되었습니다", Toast.LENGTH_SHORT)
                    toast.show()
                }
                else {
                    val toast = Toast.makeText(this, "${data1[i]}가 체크 해제되었습니다", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }

            builder.setNegativeButton("취소", null)
            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                val alert = dialogInterface as AlertDialog

                binding.textView.text = ""

                val positions = alert.listView.checkedItemPositions

                positions.forEach { key, value ->
                    if(value) {
                        binding.textView.append("${data1[key]} ")
                    }
                }

                /*for(j in 0 until positions.size()) {
                    // 체크 상태가 변경된 항목의 인덱스 번호를 추출한다.
                    val index = positions.keyAt(j)

                    if(positions.get(index)) {
                        binding.textView.append("${data1[index]} ")
                    }
                }*/
            }

            builder.show()
        }
    }
}