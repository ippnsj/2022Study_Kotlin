package kr.co.softcampus.listfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.listfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val subFragment = SubFragment()
        val tran = supportFragmentManager.beginTransaction()
        tran.replace(R.id.container1, subFragment)
        tran.commit()
    }
}