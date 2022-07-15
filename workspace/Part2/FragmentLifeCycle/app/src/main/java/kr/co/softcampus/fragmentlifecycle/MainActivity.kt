package kr.co.softcampus.fragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.fragmentlifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val frag = SubFragment()

        binding.button.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.replace(R.id.container1, frag)
            tran.addToBackStack(null)
            tran.commit()
        }

        binding.button2.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            tran.remove(frag)
            tran.commit()
        }
    }
}