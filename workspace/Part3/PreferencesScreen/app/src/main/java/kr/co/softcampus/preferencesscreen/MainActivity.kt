package kr.co.softcampus.preferencesscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.preferencesscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val settingFragment = SettingFragment()
    val resultFragment = ResultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            button.setOnClickListener {
                val tran = supportFragmentManager.beginTransaction()
                tran.replace(R.id.container, settingFragment)
                tran.commit()
            }

            button2.setOnClickListener {
                val tran = supportFragmentManager.beginTransaction()
                tran.replace(R.id.container, resultFragment)
                tran.commit()
            }
        }
    }
}