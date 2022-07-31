package kr.co.softcampus.sensorlist

import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.sensorlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 센서를 관리하는 매니저를 추출한다.
        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        // 단말기에 있는 센서 리스트를 가져온다.
        val sensor_list = manager.getSensorList(Sensor.TYPE_ALL)

        binding.textView.text = ""
        // 센서 수 만큼 반복한다.
        for (sensor in sensor_list) {
            binding.textView.append("센서 이름 : ${sensor.name}\n")
            binding.textView.append("센서 종류 : ${sensor.type}\n\n")
        }
    }
}
