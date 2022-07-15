package kr.co.softcampus.fragmentview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.fragmentview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val frag = SubFragment()
        val tran = supportFragmentManager.beginTransaction()
        tran.replace(R.id.container1, frag)
        tran.commit()
    }

    fun getBinding() : ActivityMainBinding {
        return binding
    }
}