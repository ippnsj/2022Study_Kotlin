/*
참고 사이트
https://medium.com/swlh/how-to-use-view-binding-in-recyclerview-adapter-f818b96c678a
https://cliearl.github.io/posts/android/viewbinding-recyclerview/
https://underdog11.tistory.com/entry/Kotlin-%EB%A6%AC%EC%82%AC%EC%9D%B4%ED%81%B4%EB%9F%AC%EB%B7%B0%EC%97%90-%EB%B7%B0%EB%B0%94%EC%9D%B8%EB%94%A9-%EC%A0%81%EC%9A%A9%ED%95%98%EA%B8%B0-%EC%BD%94%ED%8B%80%EB%A6%B0
*/

package kr.co.softcampus.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kr.co.softcampus.recyclerview.databinding.ActivityMainBinding

data class Country(val imgRes:Int, val name:String)

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val data = arrayListOf<Country>()

    val imgRes = intArrayOf(
        R.drawable.imgflag1, R.drawable.imgflag2, R.drawable.imgflag3, R.drawable.imgflag4,
        R.drawable.imgflag5, R.drawable.imgflag6, R.drawable.imgflag7, R.drawable.imgflag8
    )

    val data1 = arrayOf(
        "토고", "프랑스 문자열을 길게 작성해주세요", "스위스", "스페인",
        "일본 문자열을 길게 작성해주세요", "독일", "브라질", "대한민국"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for(i in imgRes.indices) {
            val country = Country(imgRes[i], data1[i])
            data.add(country)
        }

        val adapter = RecyclerAdapter(data, object:RecyclerAdapter.OnItemClickListener {
            override fun onItemClick(v: View, pos: Int) {
                binding.textView.text = (v as TextView).text
            }
        })
        binding.recycler1.adapter = adapter
        // binding.recycler1.layoutManager = LinearLayoutManager(this)
        // binding.recycler1.layoutManager = GridLayoutManager(this, 2)
        binding.recycler1.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        // binding.recycler1.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
    }
}