package kr.co.softcampus.activityaction

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.activityaction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val permission_list = arrayOf(
        Manifest.permission.CALL_PHONE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestPermissions(permission_list, 0)

        binding.button.setOnClickListener {
            val uri = Uri.parse("geo:37.243243, 131.861601")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val uri = Uri.parse("https://developer.android.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            val uri = Uri.parse("tel:12341234")
            val intent = Intent(Intent.ACTION_DIAL, uri)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val uri = Uri.parse("tel:12341234")
            val intent = Intent(Intent.ACTION_CALL, uri)
            startActivity(intent)
        }
    }
}