package kr.co.softcampus.getpicture

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.net.Uri
import android.os.Build
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

                val degree = getDegree(contentUri, contentUri.path!!)

                val resizedBitmap = resizeBitmap(1024, bitmap)

                val rotatedBitmap = rotateBitmap(resizedBitmap, degree)

                binding.imageView.setImageBitmap(rotatedBitmap)

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

    // 사진의 사이즈를 조정하는 메서드
    fun resizeBitmap(targetWidth:Int, img:Bitmap) : Bitmap {
        // 이미지의 비율을 계산한다.
        val ratio = targetWidth.toDouble() / img.width.toDouble()
        // 보정될 세로 길이를 구한다.
        val targetHeight = (img.height * ratio).toInt()
        // 크기를 조정한 bitmap 객체를 생성한다.
        val result = Bitmap.createScaledBitmap(img, targetWidth, targetHeight, false)
        return result
    }

    // 이미지 회전 각도값을 구한다.
    fun getDegree(uri:Uri, imgName:String) : Float {
        var exif : ExifInterface? = null

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val photoUri = MediaStore.setRequireOriginal(uri)
            val stream = contentResolver.openInputStream(photoUri)
            exif = ExifInterface(stream!!)
        }
        else {
            exif = ExifInterface(imgName)
        }

        var degree = 0
        var ori = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1)
        when(ori) {
            ExifInterface.ORIENTATION_ROTATE_90 -> degree = 90
            ExifInterface.ORIENTATION_ROTATE_180 -> degree = 180
            ExifInterface.ORIENTATION_ROTATE_270 -> degree = 270
        }
        return degree.toFloat()
    }

    fun rotateBitmap(img:Bitmap, degree:Float) : Bitmap {
        // 각도값을 관리하는 객체
        val matrix = Matrix()
        matrix.postRotate(degree)
        // 회전된 이미지를 받아온다.
        val result = Bitmap.createBitmap(img, 0, 0, img.width, img.height, matrix, false)
        return result
    }
}