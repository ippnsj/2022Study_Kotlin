// Toast와 달리 SnackBar는 Activity 하단에 나타나는 메세지이다.

package kr.co.softcampus.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kr.co.softcampus.snackbar.databinding.ActivityMainBinding
import kr.co.softcampus.snackbar.databinding.CustomSnackbarBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var snackbarBinding : CustomSnackbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val snack1 = Snackbar.make(it, "기본 스낵바", Snackbar.LENGTH_INDEFINITE)
            snack1.setTextColor(Color.RED)
            snack1.setBackgroundTint(Color.BLUE)
            // snack1.animationMode = Snackbar.ANIMATION_MODE_SLIDE

            val callback = object : BaseTransientBottomBar.BaseCallback<Snackbar>() {
                override fun onShown(transientBottomBar: Snackbar?) {
                    super.onShown(transientBottomBar)
                    binding.textView2.text = "SnackBar가 나타났습니다"
                }

                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                    binding.textView2.text = "SnackBar가 사라졌습니다"
                }
            }
            snack1.addCallback(callback)

            snack1.setAction("Action") {
                binding.textView.text = "Action Click"
            }

            snack1.show()
        }

        binding.button2.setOnClickListener {
            // 스낵바를 만들어준다.
            val snack2 = Snackbar.make(it, "Custom SnackBar", Snackbar.LENGTH_SHORT)
            // 스낵바를 통해 보여줄 뷰를 생성한다.
            val snackView = layoutInflater.inflate(R.layout.custom_snackbar, null)

            // custom_snackbar의 뷰들을 설정해준다.
            snackbarBinding = CustomSnackbarBinding.bind(snackView)
            snackbarBinding.imageView.setImageResource(R.drawable.img_android)
            snackbarBinding.textView3.text = "새로 추가된 뷰"
            snackbarBinding.textView3.setTextColor(Color.WHITE)

            // 스낵바 레이아웃을 추출해서 새로운 뷰를 추가한다.
            val snackbarLayout = snack2.view as Snackbar.SnackbarLayout
            // snackbarLayout.removeAllViews()
            snackbarLayout.addView(snackView)

            // 스낵바에 있는 TextView를 추출해서 이를 보이지 않게 처리한다.
            val snackText = snackbarLayout.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
            snackText.visibility = View.INVISIBLE

            snack2.show()
        }
    }
}