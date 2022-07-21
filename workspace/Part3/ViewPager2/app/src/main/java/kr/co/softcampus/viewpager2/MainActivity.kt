package kr.co.softcampus.viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import kr.co.softcampus.viewpager2.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {
    private lateinit var binding : ActivityMainBinding

    val frag1 = SubFragment1()
    val frag2 = SubFragment2()
    val frag3 = SubFragment3()

    val fragList = arrayOf(frag1, frag2, frag3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBar(binding.toolbar)

        val adapter1 = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragList.size
            }

            override fun createFragment(position: Int): Fragment {
                Log.d("test", "create fragment")
                return fragList[position]
            }
        }

        binding.pager2.adapter = adapter1
    }
}