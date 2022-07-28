package kr.co.softcampus.preferencesscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import kr.co.softcampus.preferencesscreen.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding : FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_result, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultBinding.bind(view)

        val pref = PreferenceManager.getDefaultSharedPreferences(requireContext())

        val data1 = pref.getString("data1", null)
        val data2 = pref.getBoolean("data2", false)
        val data3 = pref.getBoolean("data3", false)
        val data4 = pref.getString("data4", null)
        val data5 = pref.getStringSet("data5", null)


        with(binding) {
            textView2.text = "data1 : $data1\n"
            textView2.append("data2 : $data2\n")
            textView2.append("data3 : $data3\n")
            textView2.append("data4 : $data4\n")

            for(str in data5!!) {
                textView2.append("data5 : $str\n")
            }
        }
    }
}