package kr.co.softcampus.fragmentview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.co.softcampus.fragmentview.databinding.FragmentSubBinding

class SubFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub, null)

        return view
    }

    // Fragment가 관리하는 View 내부의 View의 주소값들이 셋팅된 후
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSubBinding.bind(view)

        with(binding) {
            fragBtn1.setOnClickListener {
                fragText1.text = "Fragment 문자열"
            }

            fragBtn2.setOnClickListener {
                // MainActivity를 추출한다.
                val parent = activity as MainActivity
                val parentBinding = parent.getBinding()
                parentBinding.activityText1.text = "Activity 문자열"
            }
        }
    }
}