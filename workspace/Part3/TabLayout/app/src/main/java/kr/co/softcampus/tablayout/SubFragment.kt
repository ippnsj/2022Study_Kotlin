package kr.co.softcampus.tablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.co.softcampus.tablayout.databinding.FragmentSubBinding

class SubFragment : Fragment {
    private lateinit var binding : FragmentSubBinding
    private lateinit var title:String

    constructor(title:String) {
        this.title = title
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sub, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSubBinding.bind(view)

        with(binding) {
            textView.text = title
        }
    }
}