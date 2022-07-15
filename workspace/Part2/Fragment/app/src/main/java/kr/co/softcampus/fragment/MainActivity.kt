package kr.co.softcampus.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.co.softcampus.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val frag1 = FirstFragment()
        val frag2 = SecondFragment()

        binding.button.setOnClickListener {
            // Fragment 작업 시작
            val tran = supportFragmentManager.beginTransaction()
            // Fragment를 셋팅한다.
            // tran.add(R.id.container1, frag1)
            tran.replace(R.id.container1, frag1)
            tran.addToBackStack(null)

            tran.commit()
        }

        binding.button2.setOnClickListener {
            val tran = supportFragmentManager.beginTransaction()
            // tran.add(R.id.container1, frag2)
            tran.replace(R.id.container1, frag2)
            tran.addToBackStack(null)
            tran.commit()
        }
    }
}