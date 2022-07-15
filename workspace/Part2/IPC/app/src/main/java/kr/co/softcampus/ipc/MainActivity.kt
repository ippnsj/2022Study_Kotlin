package kr.co.softcampus.ipc

import android.app.ActivityManager
import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kr.co.softcampus.ipc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    // 접속한 서비스 객체
    var ipcService:TestService? = null

    // 서비스 접속을 관리하는 객체
    val connection = object : ServiceConnection {
        // 서비스에 접속이 성공했을 때 호출되는 메서드
        // 두 번째 : 서비스의 onBind 메서드가 반환하는 객체를 받는다.
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            // 서비스를 추출한다.
            val binder = service as TestService.localBinder
            ipcService = binder.getService()
        }

        // 서비스 접속을 해제했을 때 호출되는 메서드
        override fun onServiceDisconnected(name: ComponentName?) {
            ipcService = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 서비스가 가동중이 아니라면 서비스를 가동한다.
        val serviceIntent = Intent(this, TestService::class.java)
        val chk = isServiceRunning("kr.co.softcampus.ipc.TestService")
        if(!chk) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(serviceIntent)
            }
            else {
                startService(serviceIntent)
            }
        }

        // 서비스에 접속한다.
        bindService(serviceIntent, connection, BIND_AUTO_CREATE)

        binding.button.setOnClickListener {
            var value = ipcService?.getNumber()
            binding.textView.text = "value : $value"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // 접속한 서비스에 접속을 해제한다.
        unbindService(connection)
    }

    // 서비스 실행 여부를 검사하는 메서드
    fun isServiceRunning(name:String) : Boolean {
        val manager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        // 현재 실행중인 서비스들을 가져온다.
        // 이전에는 해당 함수를 이용하여 다른 앱에서 실행중인 서비스에 대한 정보도 가져올 수 있었다.
        // 보안상의 이유로 현재는 실행중인 앱의 서비스만을 가져온다.
        // 그래서 잘 작동하지만 추후에 함수 자체가 사라질 수는 있다.
        val serviceList = manager.getRunningServices(Int.MAX_VALUE)

        for(serviceInfo in serviceList) {
            if(serviceInfo.service.className == name) {
                return true
            }
        }

        return false
    }
}