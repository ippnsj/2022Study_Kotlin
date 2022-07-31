package kr.co.softcampus.sensor2

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.sensor2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        val listener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent?) {
                when(event?.sensor?.type) {
                    Sensor.TYPE_ACCELEROMETER -> {
                        binding.textView.text = "X축 기울기 : ${event?.values[0]}"
                        binding.textView2.text = "Y축 기울기 : ${event?.values[1]}"
                        binding.textView3.text = "Z축 기울기 : ${event?.values[2]}"
                    }
                    Sensor.TYPE_MAGNETIC_FIELD -> {
                        binding.textView.text = "X축 주변 자기장 : ${event?.values[0]}"
                        binding.textView2.text = "Y축 주변 자기장 : ${event?.values[1]}"
                        binding.textView3.text = "Z축 주변 자기장 : ${event?.values[2]}"
                    }
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

        }

        with(binding) {
            button.setOnClickListener {
                val sensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
                val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

                if(!chk) {
                    textView.text = "가속도 센서를 지원하지 않습니다"
                }
            }

            button2.setOnClickListener {
                manager.unregisterListener(listener)
            }

            button3.setOnClickListener {
                val sensor = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)
                val chk = manager.registerListener(listener, sensor, SensorManager.SENSOR_DELAY_UI)

                if(!chk) {
                    textView.text = "자기장 센서를 지원하지 않습니다"
                }
            }

            button4.setOnClickListener {
                manager.unregisterListener(listener)
            }
        }
    }
}