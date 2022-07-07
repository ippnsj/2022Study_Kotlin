package kr.co.softcampus.permission

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.permission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val permission_list = arrayOf(
        Manifest.permission.INTERNET,
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.READ_CONTACTS,
        Manifest.permission.WRITE_CONTACTS,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            textView.text = ""

            for(permission in permission_list) {
                val chk = checkCallingOrSelfPermission(permission)

                if(chk == PackageManager.PERMISSION_GRANTED) {
                    textView.append("$permission : 허용\n")
                }
                else if(chk == PackageManager.PERMISSION_DENIED) {
                    textView.append("$permission : 거부\n")
                }
            }

            button.setOnClickListener {
                // 거부되어 있는 권한들을 사용자에게 확인받는다.
                requestPermissions(permission_list, 0)
            }
        }
    }

    // 사용자에게 허용 여부를 확인 받으면 자동으로 호출되는 메서드
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        binding.textView.text = ""

        for(idx in grantResults.indices) {
            if(grantResults[idx] == PackageManager.PERMISSION_GRANTED) {
                binding.textView.append("${permissions[idx]} : 허용\n")
            }
            else if(grantResults[idx] == PackageManager.PERMISSION_DENIED) {
                binding.textView.append("${permissions[idx]} : 거부\n")
            }
        }
    }
}