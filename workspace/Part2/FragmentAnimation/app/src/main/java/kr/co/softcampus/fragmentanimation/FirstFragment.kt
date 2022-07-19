package kr.co.softcampus.fragmentanimation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.co.softcampus.fragmentanimation.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding : FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        with(binding) {
            firstButton1.setOnClickListener {
                val mainActivity = activity as MainActivity
                mainActivity.setFragment("second")
            }
        }
    }
}