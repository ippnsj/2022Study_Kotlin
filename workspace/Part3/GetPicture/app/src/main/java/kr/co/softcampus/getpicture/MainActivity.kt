package kr.co.softcampus.getpicture

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import kr.co.softcampus.getpicture.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var cameraLauncher : ActivityResultLauncher<Intent>
    private lateinit var cameraLauncher2 : ActivityResultLauncher<Intent>

    lateinit var contentUri : Uri

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cameraLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK) {
                val bitmap = result.data?.getParcelableExtra<Bitmap>("data")
                binding.imageView.setImageBitmap(bitmap)
            }
        }

        cameraLauncher2 = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK) {
                val bitmap = BitmapFactory.decodeFile(contentUri.path)
                binding.imageView.setImageBitmap(bitmap)

                // 사진 파일을 삭제한다.
                val file = File(contentUri.path)
                file.delete()
            }
        }

        val file_path = getExternalFilesDir(null).toString()

        with(binding) {
            button.setOnClickListener {
                val intent1 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                cameraLauncher.launch(intent1)
            }

            button2.setOnClickListener {
                val intent2 = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

                // 촬영한 사진이 저장될 파일이름
                val file_name = "/temp_${System.currentTimeMillis()}.jpg"
                // 경로 + 파일 이름
                val pic_path = "$file_path/$file_name"

                val file = File(pic_path)

                // 사진이 저장될 위치를 관리하는 uri 객체
                contentUri = FileProvider.getUriForFile(this@MainActivity, "kr.co.softcampus.camera.file_provider", file)

                if(contentUri != null) {
                    intent2.putExtra(MediaStore.EXTRA_OUTPUT, contentUri)
                    cameraLauncher2.launch(intent2)
                }
            }
        }
    }
}