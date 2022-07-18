package kr.co.softcampus.dialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.dialogfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val subFragment = SubFragment()
            subFragment.show(supportFragmentManager, "dialog1")
        }
    }

    fun getBinding() : ActivityMainBinding {
        return binding
    }
}