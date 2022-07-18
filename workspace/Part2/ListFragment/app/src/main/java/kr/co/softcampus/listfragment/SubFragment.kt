package kr.co.softcampus.listfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import kr.co.softcampus.listfragment.databinding.FragmentSubBinding

class SubFragment : ListFragment() {
    private lateinit var binding : FragmentSubBinding

    val data1 = arrayOf("항목1", "항목2", "항목3", "항목4", "항목5", "항목6")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub, null)

        listAdapter = ArrayAdapter<String>(activity as MainActivity, android.R.layout.simple_list_item_1, data1)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubBinding.bind(view)
    }

    // 리스트뷰의 항목을 터치했을 때 호출되는 메서드
    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        with(binding) {
            subText1.text = data1[position]
        }
    }
}