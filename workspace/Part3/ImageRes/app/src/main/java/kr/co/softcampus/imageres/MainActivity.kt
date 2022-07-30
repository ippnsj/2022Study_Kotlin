package kr.co.softcampus.imageres

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.imageres.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            imageView2.setImageResource(R.drawable.img_android)

            // Bitmap : JPG, PNG, GIF 파일로부터 읽어온 이미지 데이터를 관리
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.img_android)
            imageView3.setImageBitmap(bitmap)

            // Drawable : Bitmap을 포함한 다양한 타입으로부터 이미지 데이터를 관리
            val drawable = getDrawable(R.drawable.img_android)
            imageView4.setImageDrawable(drawable)

            // 배경 타일 이미지를 생성한다.
            // container.setBackgroundResource(R.drawable.tile)

            val drawable2 = getDrawable(R.drawable.tile)
            container.background = drawable2

            // layer 이미지를 사용한다.
            val drawable3 = getDrawable(R.drawable.layer)
            imageView4.setImageDrawable(drawable3)

            // 상태 이미지를 사용한다.
            val drawable4 = getDrawable(R.drawable.btn_image)
            button.background = drawable4
        }
    }
}