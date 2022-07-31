package kr.co.softcampus.gps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import kr.co.softcampus.gps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    val permission_list = arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestPermissions(permission_list, 0)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        with(binding) {
            for(r1 in grantResults) {
                if(r1 == PackageManager.PERMISSION_DENIED) return
            }

            // 위치 정보를 관리하는 매니저를 추출한다.
            val manager = getSystemService(LOCATION_SERVICE) as LocationManager

            // 저장되어 있는 위치 정보값을 가져온다.
            if (ActivityCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this@MainActivity,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                return
            }

            val location1 = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            val location2 = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

            if(location1 != null) {
                showInfo(location1)
            }
            else if(location2 != null) {
                showInfo(location2)
            }

            val listener = LocationListener {
                showInfo(it)
            }

            button.setOnClickListener {
                if(manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0f, listener)
                }
                if(manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
                    manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0f, listener)
                }
            }

            button2.setOnClickListener {
                manager.removeUpdates(listener)
            }
        }
    }

    fun showInfo(location : Location) {
        if(location != null) {
            binding.textView.text = "Provider : ${location.provider}"
            binding.textView2.text = "위도 : ${location.latitude}"
            binding.textView3.text = "경도 : ${location.longitude}"
        }
    }
}