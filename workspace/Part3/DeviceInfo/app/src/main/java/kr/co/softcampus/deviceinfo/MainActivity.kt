package kr.co.softcampus.deviceinfo

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Point
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.TelecomManager
import android.telephony.TelephonyManager
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import kr.co.softcampus.deviceinfo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    val permission_list = arrayOf(
        Manifest.permission.READ_PHONE_STATE,
        Manifest.permission.READ_SMS,
        Manifest.permission.READ_PHONE_NUMBERS
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestPermissions(permission_list, 0)

        with(binding) {
            button.setOnClickListener {
                // TelephonyManager를 추출한다.
                val manager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager

                if (ActivityCompat.checkSelfPermission(
                        this@MainActivity,
                        Manifest.permission.READ_SMS
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this@MainActivity,
                        Manifest.permission.READ_PHONE_NUMBERS
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this@MainActivity,
                        Manifest.permission.READ_PHONE_STATE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    // NO PERMISSION
                    textView.text = "권한을 허용해주세요"
                }
                else {
                    textView.text = "전화번호 : ${manager.line1Number}\n"
                    textView.append("SIM 국가 코드 : ${manager.simCountryIso}\n")
                    textView.append("모바일 국가코드 + 모바일 네트워크 코드 : ${manager.simOperator}\n")
                    textView.append("서비스 이름 : ${manager.simOperatorName}\n")
                    textView.append("SIM 상태(통신 가능여부, PIN LOCK 여부) : ${manager.simState}")
                    textView.append("음성 메일 번호 : ${manager.voiceMailNumber}")
                }
            }

            button2.setOnClickListener {
                textView.text = "보드 이름 : ${Build.BOARD}\n"
                textView.append("소프트웨어를 커스터마이징한 회사 : ${Build.BRAND}\n")
                textView.append("제조사 디자인명 : ${Build.DEVICE}\n")
                textView.append("사용자에게 표시되는 빌드 ID : ${Build.DISPLAY}\n")
                textView.append("빌드 고유 ID : ${Build.FINGERPRINT}\n")
                textView.append("ChangeList 번호 : ${Build.ID}\n")
                textView.append("제품/하드웨어 제조업체 : ${Build.MANUFACTURER}\n")
                textView.append("제품 모델명 : ${Build.MODEL}\n")
                textView.append("제품명 : ${Build.PRODUCT}\n")
                textView.append("빌드 구분 : ${Build.TAGS}\n")
                textView.append("빌드 타입 : ${Build.TYPE}\n")
                textView.append("안드로이드 버전 : ${Build.VERSION.RELEASE}\n")
            }

            button3.setOnClickListener {
                val wm = getSystemService(WINDOW_SERVICE) as WindowManager

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    val matrix = wm.currentWindowMetrics

                    val width = matrix.bounds.width()
                    val height = matrix.bounds.height()

                    textView.text = "width : $width\n"
                    textView.append("height : $height\n")
                }
                else {
                    val display = wm.defaultDisplay

                    val point = Point()
                    display.getSize(point)

                    textView.text = "width : ${point.x}\n"
                    textView.append("height : ${point.y}\n")
                }
            }
        }
    }
}