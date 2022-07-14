// Broad Cast Receiver는 사용자의 요청이나 시스템에서 사건이 발생할 경우,
// 개발자가 만든 코드를 동작시킬 수 있는 실행 단위이다.

package kr.co.softcampus.broadcastapp1

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.broadcastapp1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val br = TestReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 8.0 이상부터는 코드를 통해 등록하고 해제해야 한다.
        // 그렇기 때문에 이 앱이 실행중인 경우에만 동작한다.
        // 보안상의 이유로 8.0 이상부터 변경되었다.
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val filter = IntentFilter("kr.co.softcampus.testbr")
            registerReceiver(br, filter)
        }

        binding.button.setOnClickListener {
            // val brIntent = Intent(this, TestReceiver::class.java)
            val brIntent = Intent("kr.co.softcampus.testbr")
            sendBroadcast(brIntent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            unregisterReceiver(br)
        }
    }
}