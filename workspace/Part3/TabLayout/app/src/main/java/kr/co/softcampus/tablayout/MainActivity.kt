package kr.co.softcampus.tablayout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kr.co.softcampus.tablayout.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {
    private lateinit var binding: ActivityMainBinding

    // ViewPager2에 셋팅하기 위한 Fragment들을 가지고 있는 ArrayList
    val fragmentList = ArrayList<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for(i in 0..9) {
            val sub = SubFragment("$i 번째 Fragment")
            fragmentList.add(sub)
        }

        val adapter1 = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragmentList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }
        }

        with(binding) {
            setActionBar(toolbar)

            toolbar.setTitleTextColor(Color.WHITE)
            tabs.setTabTextColors(Color.GRAY, Color.RED)

            pager2.adapter = adapter1

            // tab과 viewPager를 연결한다.
            TabLayoutMediator(tabs, pager2) { tab: TabLayout.Tab, i: Int ->
                tab.text = "탭 $i"
            }.attach()
        }
    }
}