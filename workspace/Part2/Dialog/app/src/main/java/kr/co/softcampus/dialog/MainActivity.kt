package kr.co.softcampus.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import kr.co.softcampus.dialog.databinding.ActivityMainBinding
import kr.co.softcampus.dialog.databinding.CustomDialogBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var customDialogBinding: CustomDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val builder = AlertDialog.Builder(this)

            builder.setTitle("기본 다이얼로그")
            builder.setMessage("기본 다이얼로그 입니다")
            builder.setIcon(R.mipmap.ic_launcher)

            builder.setPositiveButton("Positive") { dialogInterface: DialogInterface, i: Int ->
                binding.textView.text = "Positive 버튼을 눌렀습니다"
            }
            builder.setNeutralButton("Neutral") { dialogInterface: DialogInterface, i: Int ->
                binding.textView.text = "Neutral 버튼을 눌렀습니다"
            }
            builder.setNegativeButton("Negative") { dialogInterface: DialogInterface, i: Int ->
                binding.textView.text = "Negative 버튼을 눌렀습니다"
            }

            builder.show()
        }

        binding.button2.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("커스텀 다이얼로그")
            builder.setIcon(R.mipmap.ic_launcher)

            val custom_view = layoutInflater.inflate(R.layout.custom_dialog, null)
            customDialogBinding = CustomDialogBinding.bind(custom_view)

            builder.setView(custom_view)

            builder.setPositiveButton("확인") { dialogInterface: DialogInterface, i: Int ->
                binding.textView.text = "${customDialogBinding.customEdit1.text}\n"
                binding.textView.append("${customDialogBinding.customEdit2.text}")
            }
            builder.setNegativeButton("취소", null)

            builder.show()
        }

        binding.button3.setOnClickListener {
            val calendar = Calendar.getInstance()

            val (year, month, day) = arrayOf( calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) )

            val datePicker_listener = DatePickerDialog.OnDateSetListener { view, y, m, d ->
                binding.textView.text = "${y}년 ${m + 1}월 ${d}일"
            }

            val picker = DatePickerDialog(this, datePicker_listener, year, month, day)

            picker.show()
        }

        binding.button4.setOnClickListener {
            val calendar = Calendar.getInstance()

            val (hour, minute) = arrayOf(calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE))

            val listener2 = TimePickerDialog.OnTimeSetListener { timePicker: TimePicker, i: Int, i1: Int ->
                binding.textView.text = "${i}시 ${i1}분"
            }

            val picker = TimePickerDialog(this, listener2, hour, minute, true)
            picker.show()
        }
    }
}