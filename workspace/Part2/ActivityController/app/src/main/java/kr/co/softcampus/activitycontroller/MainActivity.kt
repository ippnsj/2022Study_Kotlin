package kr.co.softcampus.activitycontroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.activitycontroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val inputFragment = InputFragment()
    val resultFragment = ResultFragment()

    // Fragment들이 사용할 변수
    var value1 = ""
    var value2 = ""

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment("input")
    }

    fun setFragment(name:String) {
        val tran = supportFragmentManager.beginTransaction()

        when(name) {
            "input" -> {
                tran.replace(R.id.container1, inputFragment)
            }
            "result" -> {
                tran.replace(R.id.container1, resultFragment)
                tran.addToBackStack(null)
            }
        }
        tran.commit()
    }
}