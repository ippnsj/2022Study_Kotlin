package kr.co.softcampus.fragmentanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import kr.co.softcampus.fragmentanimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    val firstFragment = FirstFragment()
    val secondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment("first")
    }

    fun setFragment(name:String) {
        val tran = supportFragmentManager.beginTransaction()

        when(name) {
            "first" -> {
                tran.replace(R.id.container1, firstFragment)
            }
            "second" -> {
                // tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                // tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                // tran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)

                // 나타나는 프래그먼트의 애니메이션
                // 사라지는 프래그먼트의 애니메이션
                // 이전 프래그먼트로 돌아올 때 나타나는 프래그먼트의 애니메이션
                // 이전 프로그먼트로 돌아올 때 사라지는 프래그먼트의 애니메이션
                // tran.setCustomAnimations(R.anim.fade_xml1, R.anim.fade_xml2, R.anim.fade_xml1, R.anim.fade_xml2)
                tran.setCustomAnimations(R.anim.slide_xml1, R.anim.slide_xml2, R.anim.slide_xml3, R.anim.slide_xml4)

                tran.replace(R.id.container1, secondFragment)
                tran.addToBackStack(null)
            }
        }

        tran.commit()
    }
}