package kr.co.softcampus.sensor1

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.sensor1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 단말기의 센서들을 관리하는 객체를 추출한다.
        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        // 센서에서 값을 가져오면 반응하는 리스너
        val listener = object : SensorEventListener {
            // 센서로부터 측정된 값이 변경되었을 때 호출
            override fun onSensorChanged(event: SensorEvent?) {
                // 센서 타입에 따라 분기
                when(event?.sensor?.type) {
                    Sensor.TYPE_LIGHT -> {
                        binding.textView.text = "주변 밝기 : ${event?.values[0]} lux"
                    }
                    Sensor.TYPE_PRESSURE -> {
                        binding.textView.text = "현재 기압 : ${event?.values[0]} millibar"
                    }
                    Sensor.TYPE_PROXIMITY -> {
                        binding.textView.text = "물체와의 거리 : ${event?.values[0]} cm"
                    }
                    Sensor.TYPE_GYROSCOPE -> {
                        binding.textView.text = "X축 각속도 : ${event?.values[0]}"
                        binding.textView2.text = "Y축 각속도 : ${event?.values[1]}"
                        binding.textView3.text = "Z축 각속도 : ${event?.values[2]}"
                    }
                }
            }

            // 센서의 감도가 변경되었을 때 호출 (센서의 민감도)
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }

        }

        with(binding) {
            button.setOnClickListener {
                // 조도 센서 객체를 얻어온다.
                val sensor = manager.getDefaultSensor(Sensor.TYPE_LIGHT)
                // 조도 센서와 리스너를 연결한다.
                val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

                if(!chk) {
                    textView.text = "조도 센서를 지원하지 않습니다"
                }
            }

            button2.setOnClickListener {
                manager.unregisterListener(listener)
            }

            button3.setOnClickListener {
                val sensor = manager.getDefaultSensor(Sensor.TYPE_PRESSURE)
                val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

                if(!chk) {
                    textView.text = "기압 센서를 지원하지 않습니다"
                }
            }

            button4.setOnClickListener {
                manager.unregisterListener(listener)
            }

            button5.setOnClickListener {
                val sensor = manager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
                val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

                if(!chk) {
                    textView.text = "근접 센서를 지원하지 않습니다"
               }
            }

            button6.setOnClickListener {
                manager.unregisterListener(listener)
            }

            button7.setOnClickListener {
                val sensor = manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
                val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

                if(!chk) {
                    textView.text = "자이로 스코프 센서를 지원하지 않습니다"
                }
            }

            button8.setOnClickListener {
                manager.unregisterListener(listener)
            }
        }
    }
}