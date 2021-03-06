package kr.co.softcampus.sqlitedatabase2

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.sqlitedatabase2.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                val helper = DBHelper(this@MainActivity)

                // 데이터 준비
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val now = sdf.format(Date())

                // 컬럼에 저장될 데이터를 관리하는 객체
                val cv1 = ContentValues()
                cv1.put("textData", "문자열1")
                cv1.put("intData", 100)
                cv1.put("floatData", 11.11)
                cv1.put("dateData", now)

                helper.writableDatabase.insert("TestTable", null, cv1)

                val cv2 = ContentValues()
                cv2.put("textData", "문자열2")
                cv2.put("intData", 200)
                cv2.put("floatData", 22.22)
                cv2.put("dateData", now)

                helper.writableDatabase.insert("TestTable", null, cv2)

                helper.writableDatabase.close()

                textView.text = "저장완료"
            }

            button2.setOnClickListener {
                val helper = DBHelper(this@MainActivity)

                // 첫 번째 : 가져올 데이터가 있는 테이블의 이름
                // 두 번째 : 가져올 컬럼의 이름이 담겨져 있는 문자열 배열, null일 경우에는 모든 컬럼
                // 세 번째 : 조건절 (ex. idx = ? and name = ?), 조건절이 필요가 없으면 null
                // 네 번째 : 조건절 ? 에 바인딩될 값 배열, 세 번째가 null 이면 여기도 null
                // 다섯 번째 : Group By 기준 컬럼
                // 여섯 번째 : having 절에 들어갈 조건문
                // 일곱 번째 : 정렬 기준
                val c1 = helper.writableDatabase.query("TestTable", null, null,
                    null, null, null, null)

                textView.text = ""

                while (c1.moveToNext()) {
                    val idx1 = c1.getColumnIndex("idx")
                    val idx2 = c1.getColumnIndex("textData")
                    val idx3 = c1.getColumnIndex("intData")
                    val idx4 = c1.getColumnIndex("floatData")
                    val idx5 = c1.getColumnIndex("dateData")

                    val idx = c1.getInt(idx1)
                    val textData = c1.getString(idx2)
                    val intData = c1.getInt(idx3)
                    val floatData = c1.getFloat(idx4)
                    val dateData = c1.getString(idx5)

                    textView.append("idx : $idx\n")
                    textView.append("textData : $textData\n")
                    textView.append("intData : $intData\n")
                    textView.append("floatData : $floatData\n")
                    textView.append("dateData : $dateData\n\n")
                }
                helper.writableDatabase.close()
            }

            button3.setOnClickListener {
                val helper = DBHelper(this@MainActivity)

                val cv = ContentValues()
                cv.put("textData", "문자열3")

                val where = "idx = ?"
                val args = arrayOf("1")

                // 테이블명, ContentValues, 조건절, 조건절 ? 에 바인딩될 값 배열
                helper.writableDatabase.update("TestTable", cv, where, args)
                
                helper.writableDatabase.close()
                
                textView.text = "수정완료"
            }

            button4.setOnClickListener {
                val helper = DBHelper(this@MainActivity)

                val where = "idx = ?"
                val args = arrayOf("1")

                // 테이블명, 조건절, 조건절 ? 에 바인딩될 값 배열
                helper.writableDatabase.delete("TestTable", where, args)

                helper.writableDatabase.close()

                textView.text = "삭제완료"
            }
        }
    }
}