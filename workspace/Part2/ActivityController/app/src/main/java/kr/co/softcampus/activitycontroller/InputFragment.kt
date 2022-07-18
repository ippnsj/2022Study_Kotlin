package kr.co.softcampus.activitycontroller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kr.co.softcampus.activitycontroller.databinding.FragmentInputBinding

class InputFragment : Fragment() {
    private lateinit var binding : FragmentInputBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_input, null)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentInputBinding.bind(view)
        val mainActivity = activity as MainActivity

        with(binding) {
            inputButton.setOnClickListener {

                mainActivity.value1 = inputEdit1.text.toString()
                mainActivity.value2 = inputEdit2.text.toString()

                mainActivity.setFragment("result")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        with(binding) {
            inputEdit1.setText("")
            inputEdit2.setText("")
        }
    }
}