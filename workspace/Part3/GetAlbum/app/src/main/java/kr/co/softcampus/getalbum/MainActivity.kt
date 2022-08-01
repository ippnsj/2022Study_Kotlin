package kr.co.softcampus.getalbum

import android.Manifest
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import kr.co.softcampus.getalbum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var albumResultLauncher: ActivityResultLauncher<Intent>

    val permission_list = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.ACCESS_MEDIA_LOCATION
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestPermissions(permission_list, 0)

        albumResultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if(result.resultCode == RESULT_OK) {
                // 선택한 이미지의 경로 데이터를 관리하는 Uri 객체를 추출한다.
                val uri = result.data?.data

                if(uri != null) {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                        // 안드로이드 10 버전부터
                        // 외부 저장소로부터 이미지파일을 읽으면 안드로이드 OS DB에 자동으로 해당 이미지 파일의 정보가 저장된다.
                        // DB에 저장된 정보를 사용하기 위해 Content Provider인 contentResolver를 넘겨주어야 한다.
                        val source = ImageDecoder.createSource(contentResolver, uri)
                        val bitmap = ImageDecoder.decodeBitmap(source)
                        binding.imageView.setImageBitmap(bitmap)
                    }
                    else {
                        // 안드로이드 9 버전까지
                        val cursor = contentResolver.query(uri, null, null, null, null)
                        if(cursor != null) {
                            cursor.moveToNext()
                            // 이미지 경로를 가져온다.
                            val index = cursor.getColumnIndex(MediaStore.Images.Media.DATA)
                            val source = cursor.getString(index)
                            // 이미지를 생성한다.
                            val bitmap = BitmapFactory.decodeFile(source)
                            binding.imageView.setImageBitmap(bitmap)
                        }
                    }
                }
            }
        }

        with(binding) {
            button.setOnClickListener {
                // 앨범에서 사진을 선택할 수 있는 액티비티를 실행한다.
                val albumIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                // 실행할 액티비티의 타입을 설정한다. (이미지를 선택할 수 있는 타입으로)
                albumIntent.type = "image/*"
                // 선택할 파일의 타입을 지정한다. (안드로이드 OS가 사전작업을 할 수 있도록 하기 위함)
                val mimeType = arrayOf("image/*")
                albumIntent.putExtra(Intent.EXTRA_MIME_TYPES, mimeType)

                albumResultLauncher.launch(albumIntent)
            }
        }
    }
}