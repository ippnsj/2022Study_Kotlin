package kr.co.softcampus.toast

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.annotation.RequiresApi
import kr.co.softcampus.toast.databinding.ActivityMainBinding
import kr.co.softcampus.toast.databinding.CustomToastBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var custom_toast_binding : CustomToastBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            // 토스트 객체를 생성한다.
            val toast = Toast.makeText(this, "기본 토스트 입니다", Toast.LENGTH_SHORT)

            // callback 객체 생성
            // android 11 이상에서만 생성하도록 if문 설정
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                val callback = object : Toast.Callback() {
                    override fun onToastHidden() {
                        super.onToastHidden()
                        binding.textView.text = "Toast 메시지가 사라졌습니다"
                    }

                    override fun onToastShown() {
                        super.onToastShown()
                        binding.textView.text = "Toast 메시지가 나타났습니다"
                    }
                }

                toast.addCallback(callback)
            }

           toast.show()
        }

        binding.button2.setOnClickListener {
            // Toast에 보여줄 View를 생성한다.
            val toastView = layoutInflater.inflate(R.layout.custom_toast, null)
            custom_toast_binding = CustomToastBinding.bind(toastView)

            custom_toast_binding.toastImage.setImageResource(R.drawable.img_android)
            custom_toast_binding.toastText.text = "Custom Toast 입니다"

            toastView.setBackgroundResource(android.R.drawable.toast_frame)

            // Toast 객체를 생성한다.
            val custom_toast = Toast(this)
            // View를 설정한다.
            custom_toast.view = toastView

            custom_toast.setGravity(Gravity.CENTER, 0, 300)
            custom_toast.duration = Toast.LENGTH_LONG

            custom_toast.show()
        }
    }
}