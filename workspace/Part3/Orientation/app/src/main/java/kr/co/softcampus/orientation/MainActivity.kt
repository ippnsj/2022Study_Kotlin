package kr.co.softcampus.orientation

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.orientation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = getSystemService(SENSOR_SERVICE) as SensorManager

        val listener = object : SensorEventListener {

            // 가속도 센서로부터 측정된 값을 담을 배열
            val accValue = FloatArray(3)
            // 자기장 센서로부터 측정된 값을 담을 배열
            val magValue = FloatArray(3)

            // 두 센서로부터 값을 얻어온 적이 있는지...
            var isGetAcc = false
            var isGetMag = false

            override fun onSensorChanged(event: SensorEvent?) {
                when(event?.sensor?.type) {
                    Sensor.TYPE_ACCELEROMETER -> {
                        accValue[0] = event?.values[0]
                        accValue[1] = event?.values[1]
                        accValue[2] = event?.values[2]

                        isGetAcc = true
                    }
                    Sensor.TYPE_MAGNETIC_FIELD -> {
                        magValue[0] = event?.values[0]
                        magValue[1] = event?.values[1]
                        magValue[2] = event?.values[2]

                        isGetMag = true
                    }
                }

                if(isGetAcc && isGetMag) {
                    // 행렬 계산을 위해 사용할 배열
                    val R = FloatArray(9)
                    val I = FloatArray(9)
                    // 행렬 계산을 한다.
                    SensorManager.getRotationMatrix(R, I, accValue, magValue)
                    // 계산된 결과에서 방위값을 추출한다.
                    val values = FloatArray(3)
                    SensorManager.getOrientation(R, values)
                    // 라디언 값을 각도 값으로 변경한다.
                    var azimuth = Math.toDegrees(values[0].toDouble()).toFloat()
                    val pitch = Math.toDegrees(values[1].toDouble()).toFloat()
                    val roll = Math.toDegrees(values[2].toDouble()).toFloat()

                    if(azimuth < 0) {
                        azimuth += 360f
                    }
                    binding.textView.text = "방위값 : $azimuth"
                    binding.textView2.text = "좌우 기울기값 : $pitch"
                    binding.textView3.text = "앞뒤 기울기값 : $roll"

                    binding.imageView.rotation = 360 - azimuth
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            }

        }

        with(binding) {
            button.setOnClickListener {
                val sensor1 = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
                val sensor2 = manager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)

                manager.registerListener(listener, sensor1, SensorManager.SENSOR_DELAY_UI)
                manager.registerListener(listener, sensor2, SensorManager.SENSOR_DELAY_UI)
            }

            button2.setOnClickListener {
                manager.unregisterListener(listener)
            }
        }
    }
}